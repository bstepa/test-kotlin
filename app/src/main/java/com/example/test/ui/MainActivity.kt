package com.example.test.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material.MaterialTheme
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.datasource.network.KtorClient
import com.example.test.datasource.network.service.TestService
import com.example.test.ui.screen.TestScreen
import io.ktor.client.*
import kotlinx.serialization.ExperimentalSerializationApi


@ExperimentalSerializationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val httpClient = KtorClient.build()
        setContent {
            MaterialTheme {
                BoxWithConstraints {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Test.route,
                        builder = {
                            addTestScreen(
                                navController = navController,
                                httpClient = httpClient
                            )
                        }
                    )
                }
            }
        }
    }
}

fun NavGraphBuilder.addTestScreen(
    navController: NavController,
    httpClient: HttpClient,
) {
    val testService = TestService(httpClient)
    composable(
        route = Screen.Test.route,
    ) {
        TestScreen(
            service = testService,
        )
    }
}
