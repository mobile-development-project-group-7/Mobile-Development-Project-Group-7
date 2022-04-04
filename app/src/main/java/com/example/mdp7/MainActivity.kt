package com.example.mdp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.mdp7.ui.theme.MDP7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MDP7Theme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SettingsView()
                }
            }
        }
    }
}




@Composable
fun SettingsView() {


    var name by remember {
        mutableStateOf("")
    }

    var total by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf("")
    }

    Column() {
        Text(text = "Settings")

        Text(text = "Set Your Budget")
        Text(text = "Per month")
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }
        Text(text = "New remider")

        Row() {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Bill")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Income")
            }
        }
        Row() {
            Text(text = "Name:")
            OutlinedTextField(value = name, onValueChange ={name=it} )
        }

        Row() {
            Text(text = "Total:")
            OutlinedTextField(value = total, onValueChange ={total=it} )
        }

        Row() {
            Text(text = "Date:")
            OutlinedTextField(value = date, onValueChange ={date=it} )
        }

        Row() {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Weekly")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Monthly")
            }
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text(text = "Annual")
            }
        }

        Text(text = "Choose category:")


        Text(text = "Send me notification")
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }

    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MDP7Theme {
        SettingsView()
    }
}