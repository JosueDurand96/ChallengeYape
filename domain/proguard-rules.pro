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

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Evitar que ProGuard elimine u ofusque los nombres de los campos de Recipe (importante para la serialización)
-keepclassmembers class com.durand.domain.model.Recipe {
    <fields>;
}

# Mantener compatibilidad con la serialización de KotlinX
-keep class kotlinx.serialization.** { *; }
-dontwarn kotlinx.serialization.**

# Evitar advertencias de Retrofit y Gson
-dontwarn retrofit2.**
-dontwarn com.google.gson.**

# Mantener la clase GetRecipesUseCase para evitar problemas con Hilt
-keep class com.durand.domain.usecase.GetRecipesUseCase { *; }

# Mantener la interfaz RecipeRepository usada en el caso de uso
-keep interface com.durand.domain.repository.RecipeRepository

# Mantener las clases del modelo Recipe usadas en la capa de dominio
-keep class com.durand.domain.model.Recipe { *; }

# Evitar que ProGuard elimine métodos de Flow
-keep class kotlinx.coroutines.flow.** { *; }
-dontwarn kotlinx.coroutines.flow.**

# Mantener todas las anotaciones de Hilt
-keep @interface dagger.**
-keep @interface javax.inject.**
-keep class dagger.** { *; }
-keep class javax.inject.** { *; }
-dontwarn dagger.**
-dontwarn javax.inject.**