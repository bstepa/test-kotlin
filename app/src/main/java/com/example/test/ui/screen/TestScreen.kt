package com.example.test.ui.screen

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.test.datasource.network.service.TestService
import com.example.test.domain.Test
import kotlinx.coroutines.runBlocking


@Composable
fun TestScreen(
    service: TestService
){

    val test = remember { mutableStateOf<Test?>(null) }

    Row() {
        Text(text = test.value?.url ?: "nothing yet")

        Button(onClick = {
            runBlocking {
                test.value = service.getTest()
            }
        }){
            Text("test")
        }
    }

}