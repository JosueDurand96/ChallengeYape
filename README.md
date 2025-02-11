# 🍽 Recetario Internacional 🌍

**Recetario Internacional** es una aplicación móvil desarrollada en **Kotlin** con **Jetpack Compose**, que permite a los usuarios explorar recetas icónicas de distintos países del mundo. Con una interfaz moderna y atractiva, podrás navegar entre las recetas, conocer su descripción y visualizar en un mapa la ubicación del país al que pertenecen.

---

## 🚀 Características Principales
✔️ **Búsqueda de recetas** con un listado interactivo.  
✔️ **Visualización detallada** de cada receta con imágenes y descripciones.  
✔️ **Integración con Google Maps** para mostrar la ubicación del país de origen de cada platillo.  
✔️ **Interfaz adaptable (Responsive Design)** para dispositivos móviles y tablets.  
✔️ **Arquitectura limpia (Clean Architecture)** con modularización y separación de responsabilidades.  
✔️ **Optimización con ProGuard** para mejorar la seguridad y reducir el tamaño del APK.  
✔️ **Pruebas unitarias e instrumentadas** con JUnit, Mockk y Turbine.  

---

## 🎨 Flujo de la Aplicación
1️⃣ **Pantalla de Inicio (HomeScreen)**  
   - Lista de recetas con buscador.  
   - Vista previa de cada platillo con imagen y nombre.  

2️⃣ **Pantalla de Descripción (DetailScreen)**  
   - Descripción detallada del platillo.  
   - Imagen en alta calidad.  

3️⃣ **Pantalla de Mapa (MapScreen)**  
   - Muestra en **Google Maps** la ubicación del país de origen de la receta.  
   - Permite al usuario visualizar geográficamente la procedencia del platillo.  

---

## 🛠 Tecnologías y Librerías Utilizadas
| 🔧 Tecnología  | 📌 Uso en el Proyecto |
|--------------|----------------------|
| **Jetpack Compose** | UI declarativa moderna para Android. |
| **Navigation Compose** | Manejo de rutas y navegación fluida. |
| **Dagger Hilt** | Inyección de dependencias para escalabilidad y mantenimiento. |
| **Retrofit** | Consumo de la API REST. |
| **Coil** | Carga y renderizado eficiente de imágenes. |
| **Google Maps API** | Geolocalización de las recetas en el mapa. |
| **Coroutines & Flow** | Programación asíncrona y manejo de datos reactivos. |
| **JUnit, Mockk & Turbine** | Pruebas unitarias e instrumentadas. |
| **ProGuard** | Ofuscación y optimización del código. |

---

## 📦 Estructura del Proyecto
Este proyecto sigue los principios de **Clean Architecture** y está modularizado en tres capas principales:

