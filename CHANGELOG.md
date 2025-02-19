# M4
  * Avoid forcing discrete GPU on multi-GPU MacOS machines in [Skiko](https://github.com/JetBrains/skiko/pull/83) and [native distributions](https://github.com/JetBrains/compose-jb/issues/545)
  * Fixed [memory leak](https://github.com/JetBrains/compose-jb/issues/538)
  * Improved [keyboard support in TextField](https://android-review.googlesource.com/c/platform/frameworks/support/+/1578803)

# M3 (Feb 2021)
   * Improve [TextField](https://github.com/JetBrains/compose-jb/issues/277)
   * Support [SVG](https://github.com/JetBrains/compose-jb/tree/master/tutorials/Image_And_Icons_Manipulations#loading-svg-images)
   * Support [vsync](https://github.com/JetBrains/skiko/pull/44),  [sync composition with rendering frames](https://android-review.googlesource.com/c/platform/frameworks/support/+/1534675)
   * Support [DirectX on Windows by default](https://github.com/JetBrains/skiko/pull/63)
   * Support [software rendering fallback](https://github.com/JetBrains/skiko/pull/56)
   * Implement [signing and notarization for macOS](https://github.com/JetBrains/compose-jb/tree/master/tutorials/Signing_and_notarization_on_macOS)
   * Improve Swing interoperability support [Swing component in Compose hierarchy](https://github.com/JetBrains/compose-jb/tree/master/tutorials/Swing_Integration#adding-a-swing-component-to-cfd-composition-using-swingpanel)
   * Support using [Compose in IntelliJ plugins](https://github.com/JetBrains/compose-jb/tree/master/examples/intelliJPlugin)
   * Skiko native binaries are now signed on macOS (x64 and arm)
   * Fix [Ambients are not transferred across pop ups](https://github.com/JetBrains/compose-jb/issues/135)
   * Fix [Laggy UI on Linux](https://github.com/JetBrains/compose-jb/issues/23)
   * Fix [Using AndroidX Compose specific dependencies for Android target](https://github.com/JetBrains/compose-jb/issues/272)

# M2 (Dec 2020)
   * Swing interoperability support (Compose in Swing frame)
   * Support [XML vector images](https://developer.android.com/guide/topics/graphics/vector-drawable-resources)
   * [Support for Gradle 6.6 and 6.7](https://github.com/JetBrains/compose-jb/issues/66)
   * [Support macOS 10.13 and 10.14](https://github.com/JetBrains/compose-jb/issues/76)
   * Support Apple Silicon (arm64) natively
   * [Support letter spacing in text](https://github.com/JetBrains/compose-jb/issues/82)
   * [Implemented desktop "ActualDialog" and "ActualPopup"](https://github.com/JetBrains/compose-jb/issues/19)
   * [Fix input method bar positioning](https://github.com/JetBrains/compose-jb/issues/67)
   * [Fix text alignment](https://github.com/JetBrains/compose-jb/issues/92)
   * [Fix dropdown/popup positioning](https://github.com/JetBrains/compose-jb/issues/139)
   * [Fix using with Compose in same app as Java FX](https://github.com/JetBrains/compose-jb/issues/17)
   * [Added screenshots of example apps](https://github.com/JetBrains/compose-jb/issues/90)

# M1 (Nov 2020)
   * Initial release
