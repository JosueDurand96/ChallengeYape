package com.durand.challengeyape.screens.detail.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecipeImageTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private val testImageUrl = "https://fakeurl.com/pizza.jpg"

    @Before
    fun setup() {
        composeTestRule.setContent {
            ChallengeYapeTheme {
                RecipeImage(imageUrl = testImageUrl)
            }
        }
    }

    @Test
    fun verifyRecipeImageIsDisplayed() {
        composeTestRule.onNodeWithTag("RecipeImage").assertExists()
    }
}
