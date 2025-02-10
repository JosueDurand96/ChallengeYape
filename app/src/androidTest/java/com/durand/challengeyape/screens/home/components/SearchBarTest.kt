package com.durand.challengeyape.screens.home.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.text.input.TextFieldValue
import org.junit.Rule
import org.junit.Test

class SearchBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun searchBar_rendersCorrectly() {
        composeTestRule.setContent {
            SearchBar(searchQuery = TextFieldValue(""), onSearchQueryChange = {})
        }

        // Verifica que el campo de texto se muestra en la pantalla
        composeTestRule.onNodeWithTag("SearchBar").assertExists()
    }

    @Test
    fun searchBar_updatesText_whenInputChanges() {
        composeTestRule.setContent {
            var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }
            SearchBar(searchQuery = textFieldValue, onSearchQueryChange = { textFieldValue = it })
        }

        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithTag("SearchBar").performTextClearance()
        composeTestRule.waitForIdle()
    }
}