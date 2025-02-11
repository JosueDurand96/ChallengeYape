# 🍽️ Recetario Internacional 🌍

📱 Aplicación Android desarrollada en **Kotlin** con **Jetpack Compose**, que te permite explorar **las recetas más icónicas del mundo**. Desde **Ceviche peruano** hasta **Sushi japonés**, podrás descubrir la historia de cada platillo y su ubicación en el mapa. 🗺️

---

## 🚀 Funcionalidades Principales

✅ **Explora recetas** con un buscador intuitivo.  
✅ **Visualiza los detalles** de cada platillo con imágenes y descripciones detalladas.  
✅ **Consulta el país de origen** de cada receta con **Google Maps**.  
✅ **Interfaz adaptativa (Responsive Design)** para móviles y tablets.  
✅ **Arquitectura limpia (Clean Architecture)** con modularización.  
✅ **Seguridad y optimización** con **ProGuard**.  
✅ **Pruebas unitarias e instrumentadas** con JUnit, Mockk y Turbine.

---

## 🎨 Flujo de Navegación

1️⃣ **📜 Lista de Recetas**
- Un buscador que filtra recetas en tiempo real.
- Imágenes en miniatura con nombres de los platillos.

2️⃣ **📖 Detalle de la Receta**
- Imagen en alta calidad.
- Descripción del platillo con ingredientes principales.

3️⃣ **🗺️ Ubicación del Platillo**
- Muestra en **Google Maps** el país de origen de la receta.

---

## 📦 Arquitectura y Modularización

El proyecto sigue los principios de **Clean Architecture** y está dividido en **tres módulos principales**:


---

## 🔧 Tecnologías Utilizadas y Argumentación

| Tecnología  | ¿Por qué se usó? |
|--------------|----------------------|
| **Jetpack Compose** | Para una UI declarativa moderna, eficiente y fácil de escalar. |
| **Navigation Compose** | Manejo eficiente de rutas dentro de la aplicación. |
| **Dagger Hilt** | Inyección de dependencias para modularidad y escalabilidad. |
| **Retrofit** | Consumo de API REST de manera sencilla y robusta. |
| **Coil** | Carga rápida y eficiente de imágenes desde la red. |
| **Google Maps API** | Para visualizar la ubicación geográfica de cada receta. |
| **Coroutines & Flow** | Manejo de programación asíncrona sin bloqueos. |
| **JUnit, Mockk & Turbine** | Implementación de pruebas unitarias y de flujo. |
| **ProGuard** | Ofuscación y optimización del código para mayor seguridad. |

📌 **Explicación detallada de cada una:**

- **Jetpack Compose**: Permite construir interfaces declarativas con menos código, sin necesidad de usar `XML`. Su integración con `ViewModel` y `LiveData` lo hace ideal para manejar estados de UI reactivos.
- **Navigation Compose**: Facilita la navegación entre pantallas sin necesidad de usar fragmentos, reduciendo el acoplamiento y mejorando la legibilidad del código.
- **Dagger Hilt**: Gestión de dependencias automatizada, evita el uso manual de `Singletons` y mejora la mantenibilidad del código.
- **Retrofit**: Simplifica la conexión con la API REST para obtener recetas. Se combina con `GsonConverterFactory` para transformar JSON en objetos Kotlin fácilmente.
- **Coil**: Librería optimizada para Jetpack Compose que carga imágenes de manera eficiente y con soporte de caché automático.
- **Google Maps API**: Permite mostrar la ubicación exacta del país de cada receta, mejorando la experiencia del usuario.
- **Coroutines & Flow**: Manejo eficiente de llamadas a la API sin bloquear el hilo principal. `Flow` permite flujos de datos reactivos.
- **JUnit, Mockk & Turbine**:
    - **JUnit**: Framework principal para pruebas unitarias.
    - **Mockk**: Simulación de dependencias en pruebas.
    - **Turbine**: Pruebas de flujos `Flow` en Kotlin, asegurando respuestas correctas.
- **ProGuard**:
    - Reduce el tamaño del APK eliminando código no utilizado.
    - Protege contra ingeniería inversa mediante ofuscación del código.
    - Mejora el rendimiento al optimizar bytecode.

---

## 🌐 API REST

La aplicación consume datos de una API con la siguiente estructura JSON:

🔗 **[Enlace a la API](https://mocki.io/v1/a6876d70-a9b5-4328-8513-ee10d390f6a7)**

📌 **Ejemplo de respuesta JSON:**
```json
[
    {
        "nombre": "Ceviche",
        "descripcion": "Plato tradicional peruano de pescado crudo marinado en jugo de limón con cebolla, ají y cilantro.",
        "imagen": "https://cdn0.recetasgratis.net/es/posts/8/7/2/ceviche_mixto_peruano_77278_orig.jpg",
        "ciudad": "Lima",
        "pais": "Perú",
        "latitud": -12.0464,
        "longitud": -77.0428
    }
]

🚀 Desarrollado por Josue Durand