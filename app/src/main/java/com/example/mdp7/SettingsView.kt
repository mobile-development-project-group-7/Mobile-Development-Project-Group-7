package com.example.mdp7

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Slider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import com.example.mdp7.components.TransactionTypeChip


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

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h4
        )

        var sliderPosition by remember { mutableStateOf(0f) }
       Row(
           modifier = Modifier.padding(top = 30.dp)
       ) {
           Text("Set your budget €: ")
           Text(
            text =  sliderPosition.toString()
            )

       }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..1000f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colors.primary,
                activeTrackColor = MaterialTheme.colors.primary
            ),
            modifier = Modifier.width(250.dp)
        )


       Button(
            onClick = {  },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
        ) {

            Text(
                text = "Save",
                color = White)
        }

        Text(text = "New reminder")

        Row(
            modifier = Modifier.padding(top = 30.dp)
        )

        {
            val transactionTypeChipRemeberOneState = remember {
                mutableStateOf(false)
            }
            TransactionTypeChip(
                text = "Income",
                isSelected = transactionTypeChipRemeberOneState.value,
                selectedColor = Color.Blue,
                onChecked = {
                    transactionTypeChipRemeberOneState.value = it
                }
            )
            TransactionTypeChip(
                text = "Bills",
                isSelected = transactionTypeChipRemeberOneState.value,
                selectedColor = Color.Blue,
                onChecked = {
                    transactionTypeChipRemeberOneState.value = it
                }
            )
        }
        Row(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Text(text = "Name:")
            OutlinedTextField(
                value = name,
                onValueChange ={name=it},
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .padding(start = 15.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Total:")
            OutlinedTextField(
                value = total,
                onValueChange ={total=it},
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .padding(start = 15.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 10.dp)
        ) {
            Text(text = "Date:")
            OutlinedTextField(
                value = date,
                onValueChange ={date=it},
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .padding(start = 15.dp)
            )
        }

        Row(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            OutlinedButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(text = "Weekly",
                    color = Black)
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),

                modifier = Modifier.padding(start = 15.dp)) {
                Text(text = "Monthly",
                    color = White)
            }
            OutlinedButton(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.padding(start = 15.dp)
            ) {
                Text(text = "Annual",
                    color = Black)
            }
        }

        Text(text = "Choose cathegory")

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

        Button(
            onClick = {  },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            modifier = Modifier.padding(top = 20.dp)
        ) {

            Text(
                text = "Save",
                color = White)
        }

    }
}