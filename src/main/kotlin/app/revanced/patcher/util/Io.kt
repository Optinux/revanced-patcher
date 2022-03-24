package app.revanced.patcher.util

import app.revanced.patcher.writer.CachedClassWriter
import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.tree.ClassNode
import java.io.BufferedInputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.jar.JarEntry
import java.util.jar.JarInputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

internal class Io(
    private val input: InputStream,
    private val output: OutputStream,
    private val classes: MutableList<ClassNode>
) {
    private val bis = BufferedInputStream(input)
    private val classReaders = mutableMapOf<String, Pair<ClassReader, ClassNode>>()

    fun readFromJar() {
        bis.mark(Integer.MAX_VALUE)
        // create a BufferedInputStream in order to read the input stream again when calling saveAsJar(..)
        val jis = JarInputStream(bis)

        // read all entries from the input stream
        // we use JarEntry because we only read .class files
        lateinit var jarEntry: JarEntry
        while (jis.nextJarEntry.also { if (it != null) jarEntry = it } != null) {
            // if the current entry ends with .class (indicating a java class file), add it to our list of classes to return
            if (jarEntry.name.endsWith(".class")) {
                // create a new ClassNode
                val classNode = ClassNode()
                // read the bytes with a ClassReader into the ClassNode
                val cr = ClassReader(jis)
                cr.accept(
                    classNode,
                    ClassReader.EXPAND_FRAMES
                )
                // add it to our list
                classes.add(classNode)
                classReaders[jarEntry.name] = cr to classNode
            }

            // finally, close the entry
            jis.closeEntry()
        }

        // at last reset the buffered input stream
        bis.reset()
    }

    fun saveAsJar() {
        val jis = ZipInputStream(bis)
        val jos = ZipOutputStream(output)

        // first write all non .class zip entries from the original input stream to the output stream
        // we read it first to close the input stream as fast as possible
        // TODO(oSumAtrIX): There is currently no way to remove non .class files.
        lateinit var zipEntry: ZipEntry
        while (jis.nextEntry.also { if (it != null) zipEntry = it } != null) {
            if (zipEntry.name.endsWith(".class")) continue

            // create a new zipEntry and write the contents of the zipEntry to the output stream and close it
            jos.putNextEntry(ZipEntry(zipEntry))
            jos.write(jis.readBytes())
            jos.closeEntry()
        }

        // finally, close the input stream
        jis.close() // this closes the underlying BufferedInputStream!
        bis.close()
        input.close()

        // now write all the patched classes to the output stream
        for (patchedClass in classes) {
            // create a new entry of the patched class
            val name = patchedClass.name + ".class"
            jos.putNextEntry(JarEntry(name))

            // parse the patched class to a byte array and write it to the output stream
            val (cr) = classReaders[name]!!
            val cw: ClassWriter = CachedClassWriter(classReaders, cr)
            patchedClass.accept(cw)
            jos.write(cw.toByteArray())

            // close the newly created jar entry
            jos.closeEntry()
        }

        // finally, close the rest of the streams
        jos.close()
        output.close()
    }
}