package com.durand.challengeyape

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.durand.challengeyape.screens.HomeScreen
import com.durand.challengeyape.ui.theme.ChallengeYapeTheme
import com.durand.challengeyape.viewmodel.RecipesViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


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