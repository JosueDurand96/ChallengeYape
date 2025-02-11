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

## 🔧 Tecnologías Utilizadas

| Tecnología  | Propósito |
|--------------|----------------------|
| **Jetpack Compose** | UI declarativa moderna. |
| **Navigation Compose** | Manejo de rutas. |
| **Dagger Hilt** | Inyección de dependencias. |
| **Retrofit** | Consumo de API REST. |
| **Coil** | Carga eficiente de imágenes. |
| **Google Maps API** | Ubicación de recetas en el mapa. |
| **Coroutines & Flow** | Programación asíncrona. |
| **JUnit, Mockk & Turbine** | Pruebas automatizadas. |
| **ProGuard** | Ofuscación y optimización del código. |

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

