package app.revanced.patcher.writer

import org.objectweb.asm.ClassReader
import org.objectweb.asm.ClassWriter
import org.objectweb.asm.tree.ClassNode
import java.lang.reflect.Modifier

internal class CachedClassWriter(
    private val classes: MutableMap<String, Pair<ClassReader, ClassNode>>,
    cr: ClassReader
) : ClassWriter(cr, COMPUTE_FRAMES) {
    override fun getCommonSuperClass(type1: String, type2: String): String {
        println("in getCommonSuperClass")

        println("passing to super")
        try {
            return super.getCommonSuperClass(type1, type2)
        } catch (_: Exception) {}

        println("$type1.class")
        println("$type2.class")

        var class1 = getASMClass(type1)
        val class2 = getASMClass(type2)

        return if (
            Modifier.isInterface(class1.access) ||
            Modifier.isInterface(class2.access)
        ) {
            "java/lang/Object"
        } else if (class2.interfaces.contains(class1.name)) {
            type1
        } else if (class1.interfaces.contains(class2.name)) {
            type2
        } else {
            do {
                println("in do while loop: ${class1.name}")
                if (class1.superName == null) break
                class1 = getASMClass(class1.superName)
            } while (!class2.interfaces.contains(class1.name))
            class1.name
        }
    }

    private fun getASMClass(type: String, skipJava: Boolean = false): ClassNode {
        return if (!skipJava) {
            try {
                val cn = ClassNode()
                ClassReader(type).accept(
                    cn,
                    ClassReader.SKIP_DEBUG or ClassReader.SKIP_FRAMES
                )
                cn
            } catch (_: Exception) {
                getFromClasses(type)
            }
        } else {
            getFromClasses(type)
        }
    }

    private fun getFromClasses(type: String): ClassNode =
        classes["$type.class"]?.second ?: throw TypeNotPresentException(
            "$type.class does not exist in classReaders",
            null
        )
}