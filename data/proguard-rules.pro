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

# Mantener todas las clases relacionadas con Dagger Hilt
-keep class dagger.hilt.** { *; }
-keep class dagger.hilt.android.** { *; }
-keep class dagger.hilt.components.** { *; }
-keep class com.durand.data.di.** { *; }  # Mantener el módulo de red y repositorios

# Evitar eliminación de clases con @Module, @InstallIn, @Provides y @Binds
-keep @dagger.Module class * { *; }
-keep @dagger.Provides class * { *; }
-keep @dagger.Binds class * { *; }
-keep @dagger.hilt.InstallIn class * { *; }
-keep @dagger.hilt.components.SingletonComponent class * { *; }
-dontwarn dagger.hilt.**

# Mantener las interfaces de Retrofit (evitar eliminación y renombramiento)
-keep interface retrofit2.** { *; }
-keep class com.durand.data.network.** { *; }  # Mantener API
-keep class com.durand.data.repository.** { *; }  # Mantener repositorios
-keep class com.durand.domain.repository.** { *; }

# Mantener las clases de Retrofit y Gson Converter
-keep class retrofit2.Retrofit { *; }
-keep class retrofit2.converter.gson.GsonConverterFactory { *; }
-keep class com.google.gson.** { *; }

# Mantener los modelos de datos serializables usados por Gson
-keep class com.durand.domain.model.** { *; }
-keep class com.durand.data.model.** { *; }

# Evitar advertencias de ProGuard sobre Retrofit y Gson
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn com.google.gson.**

# Mantener la clase `RecipeResponse` para evitar que Gson no pueda deserializar JSON
-keep class com.durand.data.model.RecipeResponse { *; }

# Mantener la clase `Recipe` del dominio para evitar problemas de conversión
-keep class com.durand.domain.model.Recipe { *; }

# Mantener todos los campos de `RecipeResponse` y `Recipe` para Gson
-keepclassmembers class com.durand.data.model.RecipeResponse {
    <fields>;
}
-keepclassmembers class com.durand.domain.model.Recipe {
    <fields>;
}

# Evitar advertencias de ProGuard sobre Gson
-dontwarn com.google.gson.**

# Mantener la interfaz de Retrofit `RecipeApi`
-keep interface com.durand.data.network.RecipeApi { *; }

# Mantener la clase `RecipeResponse` y sus miembros para evitar problemas de serialización/deserialización
-keep class com.durand.data.model.RecipeResponse { *; }

# Mantener los modelos de datos utilizados en la API
-keep class com.durand.domain.model.Recipe { *; }

# Evitar que ProGuard remueva anotaciones de Retrofit
-keepattributes *Annotation*

# Mantener los métodos de Retrofit para evitar que sean eliminados
-keepclassmembers,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Evitar que ProGuard elimine la implementación interna de Retrofit
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn com.google.gson.**

# Mantener la clase `RecipeRepositoryImpl` y sus métodos
-keep class com.durand.data.repository.RecipeRepositoryImpl { *; }

# Mantener la inyección de dependencias de Hilt para `RecipeRepositoryImpl`
-keep class com.durand.data.repository.RecipeRepositoryImpl { @dagger.hilt.android.lifecycle.HiltViewModel *; }

# Mantener la interfaz `RecipeRepository` en el dominio
-keep interface com.durand.domain.repository.RecipeRepository { *; }

# Mantener las funciones de Flow
-keepclassmembers class kotlinx.coroutines.flow.Flow { *; }

# Evitar que se elimine la implementación de Retrofit
-keep class com.durand.data.network.RecipeApi { *; }

# Mantener la estructura del modelo de datos
-keep class com.durand.domain.model.Recipe { *; }
-keep class com.durand.data.model.RecipeResponse { *; }

# Mantener los métodos de Retrofit para evitar que sean eliminados
-keepclassmembers,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}

# Evitar advertencias relacionadas con Retrofit, OkHttp y Gson
-dontwarn retrofit2.**
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn kotlinx.coroutines.**
-dontwarn com.google.gson.**
