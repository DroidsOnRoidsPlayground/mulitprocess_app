package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds

class SlowMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        startActivity(Intent(this, LoaderActivity::class.java)) //remove to see ANR
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Column(
                    modifier = Modifier.padding(innerPadding)
                ) {
                    Counter("main")
                    ToastButton("main")
                }
            }
            LaunchedEffect(Unit) {
                delay(10.milliseconds) // prevents ANR before LoaderActivity starts
                Thread.sleep(20_000) // simulate main thread blocking
            }
        }
    }
}
