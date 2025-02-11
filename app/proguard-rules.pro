# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-keep class com.durand.challengeyape.model.** { *; }
-keep class dagger.** { *; }
-keep class com.durand.challengeyape.di.** { *; }
-keep class kotlin.Metadata { *; }
-assumenosideeffects class android.util.Log { *; }

# Mantener clases de inyección de Hilt
-keep class dagger.hilt.** { *; }
-keep class androidx.hilt.** { *; }
-keep class com.durand.challengeyape.** { *; }
-keepclassmembers class * {
    @dagger.** <fields>;
}
-keepattributes RuntimeVisibleAnnotations

# Mantener clases de Google Maps
-keep class com.google.android.gms.maps.** { *; }
-keep class com.google.maps.android.** { *; }
-keep class androidx.compose.maps.** { *; }

# Mantener clases de Coil
-keep class coil.** { *; }
-keep class coil.compose.** { *; }
-dontwarn coil.**

# Mantener clases de serialización JSON
-keep class kotlinx.serialization.** { *; }
-keep class com.durand.domain.model.** { *; }
-dontwarn kotlinx.serialization.**

# Mantener clases esenciales de Compose
-keep class androidx.compose.** { *; }
-keep class androidx.activity.compose.** { *; }
-keep class androidx.lifecycle.viewmodel.compose.** { *; }
-keep class androidx.hilt.navigation.compose.** { *; }

# Mantener clases de Navigation Compose
-keep class androidx.navigation.** { *; }
-keep class androidx.compose.navigation.** { *; }
-keep class com.durand.challengeyape.navigation.** { *; }

# Mantener clases para pruebas con Mockk y Turbine
-keep class io.mockk.** { *; }
-keep class app.cash.turbine.** { *; }
-dontwarn io.mockk.**
-dontwarn app.cash.turbine.**

# Evitar problemas con Kotlin Reflection en Navigation
-keepattributes *Annotation*
-keep class kotlin.reflect.** { *; }
-dontwarn kotlin.reflect.**

# Evitar problemas con Compose Navigation y rutas
-dontwarn androidx.navigation.**

# Mantener ViewModel y evitar eliminación de métodos públicos
-keep class com.durand.challengeyape.viewmodel.** { *; }
-keepclassmembers class * extends androidx.lifecycle.ViewModel {
    public <init>(...);
}

# Evitar problemas con Jetpack Compose
-keep class androidx.compose.runtime.** { *; }
-keep class androidx.navigation.compose.** { *; }

# Evitar advertencias de ProGuard sobre rutas en Navigation
-dontwarn androidx.navigation.toRoute