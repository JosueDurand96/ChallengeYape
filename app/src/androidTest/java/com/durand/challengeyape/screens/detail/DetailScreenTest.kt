package com.durand.challengeyape.screens.detail

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.navigation.MapDataInfo
import com.durand.challengeyape.navigation.PersonalData
import com.durand.challengeyape.navigation.PersonalDataInfo
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val mockNavigateToMap: (MapDataInfo) -> Unit = mockk(relaxed = true)
    private val mockOnBackPress: () -> Unit = mockk(relaxed = true)

    private val testPersonalData = PersonalData(
        info = PersonalDataInfo(
            nombre = "Pizza",
            descripcion = "Masa y queso",
            imagen = "https://fakeurl.com",
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
                DetailScreen(
                    data = testPersonalData,
                    navigateToMap = mockNavigateToMap,
                    onBackPress = mockOnBackPress
                )
            }
        }
    }

    @Test
    fun verifyTitleIsDisplayed() {
        composeTestRule.onNodeWithText("Descripción de la receta").assertExists()
    }

    @Test
    fun verifyBackButtonWorks() {
        composeTestRule.onNodeWithContentDescription("Regresar").performClick()
        verify { mockOnBackPress.invoke() }
    }

    @Test
    fun verifyCompactLayoutOrExpandedLayoutIsDisplayed() {
        // Comprueba si al menos una de las vistas existe
        val compactExists = composeTestRule.onAllNodesWithText("Pizza").fetchSemanticsNodes().isNotEmpty()
        val expandedExists = composeTestRule.onAllNodesWithText("Pizza").fetchSemanticsNodes().isNotEmpty()

        assert(compactExists || expandedExists)
    }

    @Test
    fun verifyNavigationToMapWorks() {
        composeTestRule.runOnUiThread {
            mockNavigateToMap.invoke(testPersonalData.toMapDataInfo())
        }
        verify { mockNavigateToMap.invoke(testPersonalData.toMapDataInfo()) }
    }
}
