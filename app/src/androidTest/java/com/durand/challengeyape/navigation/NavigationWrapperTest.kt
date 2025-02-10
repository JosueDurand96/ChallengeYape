//package com.durand.challengeyape.navigation
//
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.test.*
//import androidx.navigation.compose.ComposeNavigator
//import androidx.navigation.testing.TestNavHostController
//import com.durand.challengeyape.viewmodel.RecipesViewModel
//import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
//import org.junit.Assert.assertEquals
//import androidx.activity.ComponentActivity
//import androidx.compose.ui.test.junit4.createAndroidComposeRule
//import org.junit.Before
//import org.junit.Rule
//import org.junit.Test
//import org.junit.runner.RunWith
//import androidx.test.ext.junit.runners.AndroidJUnit4
//import io.mockk.mockk
//
//@RunWith(AndroidJUnit4::class)
//class NavigationWrapperTest {
//
//    @get:Rule
//    val composeTestRule = createAndroidComposeRule<ComponentActivity>() // Cambiado a AndroidComposeTestRule
//
//    private lateinit var navController: TestNavHostController
//    private val viewModel: RecipesViewModel = mockk(relaxed = true) // Simulamos el ViewModel
//
//    @Before
//    fun setUp() {
//        composeTestRule.setContent {
//            val context = LocalContext.current
//            navController = TestNavHostController(context).apply {
//                navigatorProvider.addNavigator(ComposeNavigator())
//            }
//
//            ChallengeYapeTheme {
//                NavigationWrapper(viewModel = viewModel)
//            }
//        }
//    }
//
//
//    @Test
//    fun verifyInitialScreenaHomeScreen() {
//        composeTestRule.waitForIdle()
//        composeTestRule.onRoot().printToLog("UI") // Debug de UI
//
//        composeTestRule.onNodeWithText("Recetas del Mundo", useUnmergedTree = true).assertExists()
//    }
//
//    @Test
//    fun navigateToDetailScreen() {
//        composeTestRule.runOnUiThread {
//            navController.navigate(PersonalData(PersonalDataInfo("Pizza", "Masa y queso", "https://fakeurl.com", "Lima", "Peru", "10.0", "20.0")))
//        }
//
//        composeTestRule.waitForIdle()
//        assertEquals(PersonalData::class.qualifiedName, navController.currentBackStackEntry?.destination?.route)
//    }
//
//    @Test
//    fun navigateToMapScreen() {
//        composeTestRule.runOnUiThread {
//            navController.navigate(MapData(MapDataInfo("Pizza", "Masa y queso", "https://fakeurl.com", "Lima", "Peru", "10.0", "20.0")))
//        }
//
//        composeTestRule.waitForIdle()
//        assertEquals(MapData::class.qualifiedName, navController.currentBackStackEntry?.destination?.route)
//    }
//}
//
