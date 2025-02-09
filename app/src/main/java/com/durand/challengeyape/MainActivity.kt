package com.durand.challengeyape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.durand.challengeyape.screens.DetailScreen
import com.durand.challengeyape.screens.HomeScreen
import com.durand.challengeyape.screens.MapScreen
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import com.durand.challengeyape.viewmodels.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //private val viewModelFactory: ViewModelProvider.Factory by instance()
    //private val viewModel: RecipesViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChallengeYapeTheme {
                val viewModel: RecipesViewModel = hiltViewModel()
                HomeScreen(viewModel)
            }
        }
    }
}