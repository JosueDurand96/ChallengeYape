package com.durand.challengeyape.screens.detail.components

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.navigation.MapDataInfo
import com.durand.challengeyape.navigation.PersonalData
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.screens.detail.toMapDataInfo
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CompactLayoutTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val mockNavigateToMap: (MapDataInfo) -> Unit = mockk(relaxed = true)

    private val testPersonalData = PersonalData(
        info = PersonalDataInfo(
            nombre = "Pizza",
            descripcion = "Masa y queso con tomate",
            imagen = "https://fakeurl.com/pizza.jpg",
            ciudad = "Lima",
            pais = "Peru",
            latitud = "10.0",
            longitud = "20.0"
        )
    )

    @Before
    fun setup() {
        composeTestRule.setContent {
            ChallengeYapeTheme {
                CompactLayout(
                    data = testPersonalData,
                    navigateToMap = mockNavigateToMap,
                    paddingValues = PaddingValues(0.dp)
                )
            }
        }
    }

    @Test
    fun verifyRecipeImageIsDisplayed() {
        // Verifica que la imagen está presente en la pantalla
        composeTestRule.onNodeWithContentDescription("Imagen de la receta").assertExists()
    }

    @Test
    fun verifyRecipeDetailsAreDisplayed() {
        // Verifica que los detalles de la receta están presentes
        composeTestRule.onNodeWithText("Pizza").assertExists()
        composeTestRule.onNodeWithText("Masa y queso con tomate").assertExists()
        composeTestRule.onNodeWithText("Lima, Peru").assertExists()
    }

    @Test
    fun verifyMapButtonIsDisplayedAndClickable() {
        // Verifica que el botón "Ver en el mapa" existe
        composeTestRule.onNodeWithText("Ver en el mapa").assertExists()

        // Realiza un clic en el botón
        composeTestRule.onNodeWithText("Ver en el mapa").performClick()

        // Verifica que la función `navigateToMap()` se ejecutó con los datos correctos
        verify { mockNavigateToMap(testPersonalData.toMapDataInfo()) }
    }
}
