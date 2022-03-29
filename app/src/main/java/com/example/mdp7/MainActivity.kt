package com.example.mdp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mdp7.ui.theme.MDP7Theme
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MDP7Theme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.budgettracker),
            contentDescription = "Logo",
            modifier = Modifier
                .width(250.dp)
                .height(50.dp)
        )
        Text (text = "Email")
        TextField(
            Modifier
                .width(200.dp)
                .height(30.dp)
                .padding(25.dp)
        )
        Text (text = "Password")
        TextField(
            modifier = Modifier
                .width(200.dp)
                .height(30.dp)
                .padding(25.dp)
        )
        Button(onClick = { /*TODO*/ }) {
            Text("LogIn")
        }
    }
}

@Composable
fun TextField(modifier: Modifier) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(

        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )
}


@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun DefaultPreview() {
    MDP7Theme {
        MyApp()
    }
}