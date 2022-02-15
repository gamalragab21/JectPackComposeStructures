package com.developers.jectpackcomposestructures.presentation_layer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.developers.jectpackcomposestructures.presentation_layer.components.MySetupNavGraph
import com.developers.jectpackcomposestructures.presentation_layer.ui.theme.JectPackComposeStructuresTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            JectPackComposeStructuresTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {
                    // A surface container using the 'background' color from the theme
                    MySetupNavGraph(navController = navController)
                }
            }
        }
    }
}


