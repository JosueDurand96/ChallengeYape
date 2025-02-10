package com.durand.challengeyape.screens.detail.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
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
class MapButtonTest {

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
                MapButton(navigateToMap = mockNavigateToMap, data = testPersonalData)
            }
        }
    }

    @Test
    fun verifyButtonTextIsDisplayed() {
        composeTestRule.onNodeWithText("Ver en el mapa").assertExists()
    }

    @Test
    fun verifyButtonClickTriggersNavigation() {
        composeTestRule.onNodeWithText("Ver en el mapa").performClick()
        verify { mockNavigateToMap(testPersonalData.toMapDataInfo()) }
    }
}
