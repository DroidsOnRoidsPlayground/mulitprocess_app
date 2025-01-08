package com.example.myapplication

import android.widget.Toast
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun ToastButton(
    suffix: String
) {
    val context = LocalContext.current
    Button(onClick = {
        Toast.makeText(context, "Hello from $suffix", Toast.LENGTH_SHORT).show()
    }) {
        Text("Toast on $suffix")
    }
}
