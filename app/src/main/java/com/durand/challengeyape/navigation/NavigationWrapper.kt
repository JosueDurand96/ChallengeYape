package com.durand.challengeyape.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.durand.challengeyape.viewmodel.RecipesViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.durand.challengeyape.screens.DetailScreen
import com.durand.challengeyape.screens.HomeScreen
import com.durand.challengeyape.screens.MapScreen
import kotlin.reflect.typeOf

@Composable
fun NavigationWrapper(
    viewModel: RecipesViewModel,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = FirstModal) {
        composable<FirstModal> {
            HomeScreen(
                viewModel = viewModel,
                navigateToDescription = { navController.navigate(PersonalData(it)) },
            )
        }
        composable<PersonalData>(typeMap = mapOf(typeOf<PersonalDataInfo>() to createNavType<PersonalDataInfo>())) { backStackEntry ->
            val data: PersonalData = backStackEntry.toRoute()
            DetailScreen(
                data = data,
                navigateToMap = { navController.navigate(MapData(it)) },
                onBackPress = { navController.popBackStack() }
            )
        }

        composable<MapData>(typeMap = mapOf(typeOf<MapDataInfo>() to createNavType<MapDataInfo>())) { backStackEntry ->
            val data: MapData = backStackEntry.toRoute()
            MapScreen(
                data = data,
                onBackPress = { navController.popBackStack() }
            )
        }
    }

}