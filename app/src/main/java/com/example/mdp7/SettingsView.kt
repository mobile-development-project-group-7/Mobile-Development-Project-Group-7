package com.example.mdp7

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource

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
        Row() {
            Icon(painter = painterResource(id = R.drawable.ic_food), contentDescription = "food_category_icon")
            Icon(painter = painterResource(id = R.drawable.ic_transport), contentDescription = "transport_category_icon")
        }
        Row(){
            val isChecked = remember { mutableStateOf(false) }
            Checkbox(
                checked = isChecked.value,
                onCheckedChange = {
                    isChecked.value = it
                }
            )
            Text(text = "Send me notification")
        }



        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Save")
        }

    }
}