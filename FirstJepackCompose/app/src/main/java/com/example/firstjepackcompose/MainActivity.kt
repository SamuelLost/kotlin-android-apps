package com.example.firstjepackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.firstjepackcompose.ui.theme.FirstJepackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstJepackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
                        MyFirstText(name = "Samuel")
                        MyFirstText(name = "Henrique")
                    }
                }
            }
        }
    }
}

@Composable
fun MyFirstText(name: String) {
    //Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        //Column {
            Text(text = "Hello, $name!", fontSize = 24.sp)
//        }
//    }
}

@Preview
@Composable
fun PreviewGreeting() {
    FirstJepackComposeTheme {
        MyFirstText("Android")
    }
}