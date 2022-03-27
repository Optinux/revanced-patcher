# 1.0.0-dev.1 (2022-03-27)


### Bug Fixes

* avoid ignoring test resources (fixes [#1](https://github.com/Optinux/revanced-patcher/issues/1)) ([d5a3c76](https://github.com/Optinux/revanced-patcher/commit/d5a3c76389ba902c22ddc8b7ba1a110b7ff852df))
* current must be calculated after increment ([5f12bab](https://github.com/Optinux/revanced-patcher/commit/5f12bab5df97fbe6e2e62c1bf2814a2e682ab4f3))
* give ClassWriter a ClassReader for symtable ([e8f6973](https://github.com/Optinux/revanced-patcher/commit/e8f6973938c70002f04a86f329aa5b134f6ef649))
* **gradle:** publish source and javadocs ([87bbde5](https://github.com/Optinux/revanced-patcher/commit/87bbde5e06d038d8f6ddaac391e1db397f5a5590))
* **Io:** fix finding classes by name ([460d62a](https://github.com/Optinux/revanced-patcher/commit/460d62a24c4cad05691c4b269c2faeda47fee3b7))
* **Io:** JAR loading and saving ([#8](https://github.com/Optinux/revanced-patcher/issues/8)) ([4d98cbc](https://github.com/Optinux/revanced-patcher/commit/4d98cbc9e8fe1e39b3d9d4185b3c5b4882093af6))
* **MethodResolver:** fix cd57a8c9a0db7e3ae5ad0bca202e5955930319ab ([1af31b2](https://github.com/Optinux/revanced-patcher/commit/1af31b2aa3772a7473c04d27bf835c8eae13438d))
* **MethodResolver:** strip labels and line numbers so opcode patterns match ([8d1bb5f](https://github.com/Optinux/revanced-patcher/commit/8d1bb5f3d9da544cf6e3e3848bfcc56327cde810))
* **MethodResolver:** strip labels nodes so opcode patterns match ([cd57a8c](https://github.com/Optinux/revanced-patcher/commit/cd57a8c9a0db7e3ae5ad0bca202e5955930319ab))
* nullable signature members ([#10](https://github.com/Optinux/revanced-patcher/issues/10)) ([8db8893](https://github.com/Optinux/revanced-patcher/commit/8db8893ab1bda55f11cc75db55c7c1a38f1d1b16))
* Patch should have access to the Cache ([6c0f082](https://github.com/Optinux/revanced-patcher/commit/6c0f0823c91dc643dd80205b1e840e59827bee06))
* remove broken code ([0e72a6e](https://github.com/Optinux/revanced-patcher/commit/0e72a6e85ff9a6035510680fc5e33ab0cd14144f))
* set index for insertAt to 0 by default ([1769132](https://github.com/Optinux/revanced-patcher/commit/1769132a9e29cf3a0c5ae0917209c83c138c0216))
* set marklimit to Integer.MAX_VALUE ([ab6453c](https://github.com/Optinux/revanced-patcher/commit/ab6453ca8a02af70da4468c1a63c68dde4d392ef))
* workflow on dev branch ([7e67daf](https://github.com/Optinux/revanced-patcher/commit/7e67daf8789c534bed0091a3975776eb95039acc))


### Code Refactoring

* convert Patch to abstract class ([23e897a](https://github.com/Optinux/revanced-patcher/commit/23e897a7a9125f4ac4266263e7dd94fe63a0bfa1))
* Optimize Signature class ([#11](https://github.com/Optinux/revanced-patcher/issues/11)) ([49beec9](https://github.com/Optinux/revanced-patcher/commit/49beec9fc6eee6ccf52a6185761a200a6ed2b16e))
* Rename `net.revanced` to `app.revanced` ([3ab42a9](https://github.com/Optinux/revanced-patcher/commit/3ab42a932c8d5027d554106dfe8e1299ebc1ac7f))


### Features

* Add `findParentMethod` utility method ([#4](https://github.com/Optinux/revanced-patcher/issues/4)) ([00c6ab7](https://github.com/Optinux/revanced-patcher/commit/00c6ab7fafe2a59dec0052cc5b7d1d16939076b2))
* add SafeClassWriter ([ca6b94d](https://github.com/Optinux/revanced-patcher/commit/ca6b94d943b7067aae87a4e282cfb323811c0462))


### Performance Improvements

* check type instead of class ([47eb493](https://github.com/Optinux/revanced-patcher/commit/47eb493f5425dc27a4d6e79e6b02a36ef760e8da))


### BREAKING CHANGES

* Array<Int> was changed to IntArray. This breaks existing patches.
* Package name was changed from "net.revanced" to "app.revanced"
* Method signature of execute() was changed to include the cache, this will break existing implementations of the Patch class.
* Patch class is now an abstract class. You must implement it. You can use anonymous implements, like done in the tests.

# [1.0.0-dev.8](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.7...v1.0.0-dev.8) (2022-03-24)


### Performance Improvements

* check type instead of class ([47eb493](https://github.com/ReVancedTeam/revanced-patcher/commit/47eb493f5425dc27a4d6e79e6b02a36ef760e8da))

# [1.0.0-dev.7](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.6...v1.0.0-dev.7) (2022-03-24)


### Bug Fixes

* **MethodResolver:** fix cd57a8c9a0db7e3ae5ad0bca202e5955930319ab ([1af31b2](https://github.com/ReVancedTeam/revanced-patcher/commit/1af31b2aa3772a7473c04d27bf835c8eae13438d))

# [1.0.0-dev.6](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.5...v1.0.0-dev.6) (2022-03-24)


### Bug Fixes

* **MethodResolver:** strip labels nodes so opcode patterns match ([cd57a8c](https://github.com/ReVancedTeam/revanced-patcher/commit/cd57a8c9a0db7e3ae5ad0bca202e5955930319ab))

# [1.0.0-dev.5](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.4...v1.0.0-dev.5) (2022-03-24)


### Bug Fixes

* **MethodResolver:** strip labels and line numbers so opcode patterns match ([8d1bb5f](https://github.com/ReVancedTeam/revanced-patcher/commit/8d1bb5f3d9da544cf6e3e3848bfcc56327cde810))

# [1.0.0-dev.4](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.3...v1.0.0-dev.4) (2022-03-23)


### Bug Fixes

* give ClassWriter a ClassReader for symtable ([e8f6973](https://github.com/ReVancedTeam/revanced-patcher/commit/e8f6973938c70002f04a86f329aa5b134f6ef649))

# [1.0.0-dev.3](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.2...v1.0.0-dev.3) (2022-03-23)


### Features

* add SafeClassWriter ([ca6b94d](https://github.com/ReVancedTeam/revanced-patcher/commit/ca6b94d943b7067aae87a4e282cfb323811c0462))

# [1.0.0-dev.2](https://github.com/ReVancedTeam/revanced-patcher/compare/v1.0.0-dev.1...v1.0.0-dev.2) (2022-03-23)


### Bug Fixes

* set marklimit to Integer.MAX_VALUE ([ab6453c](https://github.com/ReVancedTeam/revanced-patcher/commit/ab6453ca8a02af70da4468c1a63c68dde4d392ef))

# 1.0.0-dev.1 (2022-03-23)


### Bug Fixes

* avoid ignoring test resources (fixes [#1](https://github.com/ReVancedTeam/revanced-patcher/issues/1)) ([d5a3c76](https://github.com/ReVancedTeam/revanced-patcher/commit/d5a3c76389ba902c22ddc8b7ba1a110b7ff852df))
* current must be calculated after increment ([5f12bab](https://github.com/ReVancedTeam/revanced-patcher/commit/5f12bab5df97fbe6e2e62c1bf2814a2e682ab4f3))
* **gradle:** publish source and javadocs ([87bbde5](https://github.com/ReVancedTeam/revanced-patcher/commit/87bbde5e06d038d8f6ddaac391e1db397f5a5590))
* **Io:** fix finding classes by name ([460d62a](https://github.com/ReVancedTeam/revanced-patcher/commit/460d62a24c4cad05691c4b269c2faeda47fee3b7))
* **Io:** JAR loading and saving ([#8](https://github.com/ReVancedTeam/revanced-patcher/issues/8)) ([4d98cbc](https://github.com/ReVancedTeam/revanced-patcher/commit/4d98cbc9e8fe1e39b3d9d4185b3c5b4882093af6))
* nullable signature members ([#10](https://github.com/ReVancedTeam/revanced-patcher/issues/10)) ([8db8893](https://github.com/ReVancedTeam/revanced-patcher/commit/8db8893ab1bda55f11cc75db55c7c1a38f1d1b16))
* Patch should have access to the Cache ([6c0f082](https://github.com/ReVancedTeam/revanced-patcher/commit/6c0f0823c91dc643dd80205b1e840e59827bee06))
* remove broken code ([0e72a6e](https://github.com/ReVancedTeam/revanced-patcher/commit/0e72a6e85ff9a6035510680fc5e33ab0cd14144f))
* set index for insertAt to 0 by default ([1769132](https://github.com/ReVancedTeam/revanced-patcher/commit/1769132a9e29cf3a0c5ae0917209c83c138c0216))
* workflow on dev branch ([7e67daf](https://github.com/ReVancedTeam/revanced-patcher/commit/7e67daf8789c534bed0091a3975776eb95039acc))


### Code Refactoring

* convert Patch to abstract class ([23e897a](https://github.com/ReVancedTeam/revanced-patcher/commit/23e897a7a9125f4ac4266263e7dd94fe63a0bfa1))
* Optimize Signature class ([#11](https://github.com/ReVancedTeam/revanced-patcher/issues/11)) ([49beec9](https://github.com/ReVancedTeam/revanced-patcher/commit/49beec9fc6eee6ccf52a6185761a200a6ed2b16e))
* Rename `net.revanced` to `app.revanced` ([3ab42a9](https://github.com/ReVancedTeam/revanced-patcher/commit/3ab42a932c8d5027d554106dfe8e1299ebc1ac7f))


### Features

* Add `findParentMethod` utility method ([#4](https://github.com/ReVancedTeam/revanced-patcher/issues/4)) ([00c6ab7](https://github.com/ReVancedTeam/revanced-patcher/commit/00c6ab7fafe2a59dec0052cc5b7d1d16939076b2))


### BREAKING CHANGES

* Array<Int> was changed to IntArray. This breaks existing patches.
* Package name was changed from "net.revanced" to "app.revanced"
* Method signature of execute() was changed to include the cache, this will break existing implementations of the Patch class.
* Patch class is now an abstract class. You must implement it. You can use anonymous implements, like done in the tests.
