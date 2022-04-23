package com.example.mdp7

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Slider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.input.KeyboardType
import com.example.mdp7.components.TransactionTypeChip
import java.util.*
import androidx.compose.ui.platform.LocalContext
import com.example.mdp7.components.ImageChip

@Composable
fun SettingsView() {


    var name by remember {
        mutableStateOf("")
    }

    var total by remember {
        mutableStateOf("")
    }

    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int



    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()

    val reminderDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            reminderDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )


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
                thumbColor = Color(0xFF247BA0),
                activeTrackColor = Color(0xFF247BA0)
            ),
            modifier = Modifier.width(250.dp)
        )


       Button(
            onClick = {  },
           shape = RoundedCornerShape(5.dp),
           colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF25F5C))
        ) {

            Text(
                text = "Save",
                color = White)
        }
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "New reminder",
            style = MaterialTheme.typography.h6)

        Spacer(modifier = Modifier.height(10.dp))

        Row()

        {
            val incomeChipState = remember {
                mutableStateOf(false)
            }
            val billChipState = remember {
                mutableStateOf(false)
            }


            TransactionTypeChip(
                text = "Income",
                isSelected = incomeChipState.value,
                selectedColor = Color(0xFF247BA0),
                onChecked = {
                    incomeChipState.value = it
                }
            )
            TransactionTypeChip(
                text = "Bill",
                isSelected = billChipState.value,
                selectedColor = Color(0xFF247BA0),
                onChecked = {
                    billChipState.value = it
                }
            )

        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Text(text = "Name:")
            OutlinedTextField(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .padding(start = 15.dp),
                value = name,
                onValueChange = { name = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black))
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Text(text = "Total:")
            OutlinedTextField(
                modifier = Modifier
                    .width(200.dp)
                    .height(40.dp)
                    .padding(start = 15.dp),
                value = total,
                onValueChange = { total = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black)
                )
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            border = BorderStroke(1.dp, Black),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .defaultMinSize(
                    minWidth = 120.dp,
                    minHeight = 35.dp
                ),



            onClick = {
                mDatePickerDialog.show()
            }) {
            Text(text = "Choose date",
                style = MaterialTheme.typography.body2,
                color = Color.Black)
        }

        Row(

            modifier = Modifier.padding(top = 30.dp)
        ) {

            val  weeklyChipState= remember {
                mutableStateOf(false)
            }
            val  monthlyChipState= remember {
                mutableStateOf(false)
            }
            val  annuallyChipState= remember {
                mutableStateOf(false)
            }

            TransactionTypeChip(
                text = "Weekly",
                isSelected = weeklyChipState.value,
                selectedColor = Color(0xFF247BA0),
                onChecked = {
                    weeklyChipState.value = it
                }
            )
            TransactionTypeChip(
                text = "Monthly",
                isSelected = monthlyChipState.value,
                selectedColor = Color(0xFF247BA0),
                onChecked = {
                    monthlyChipState.value = it
                }
            )
            TransactionTypeChip(
                text = "Annually",
                isSelected = annuallyChipState.value,
                selectedColor = Color(0xFF247BA0),
                onChecked = {
                    annuallyChipState.value = it
                }
            )
        }

        Text(text = "Choose category",
            style = MaterialTheme.typography.h6)
                Row(){
                    val groceriesChipState = remember {
                        mutableStateOf(false)
                    }
                    val restaurantChipState = remember {
                        mutableStateOf(false)
                    }
                    val  transportChipState= remember {
                        mutableStateOf(false)
                    }
                    val  hobbiesChipState= remember {
                        mutableStateOf(false)
                    }
                    val  householdingChipState= remember {
                        mutableStateOf(false)
                    }
                    val  healthChipState= remember {
                        mutableStateOf(false)
                    }

                    ImageChip(
                        imageVector = Icons.Rounded.LocalGroceryStore,
                        isSelected = groceriesChipState.value,
                        onChecked = {
                            groceriesChipState.value = it
                        },
                        tintColor = Color(0xFFF25F5C)
                    )
                    ImageChip(
                        imageVector = Icons.Rounded.Fastfood,
                        isSelected = restaurantChipState.value,
                        onChecked = {
                            restaurantChipState.value = it
                        },
                        tintColor = Color(0xFF67C587)
                    )
                    ImageChip(
                        imageVector = Icons.Rounded.EmojiTransportation,
                        isSelected = transportChipState.value,
                        onChecked = {
                            transportChipState.value = it
                        },
                        tintColor = Color(0xFFFFE066)
                    )
                    ImageChip(
                        imageVector = Icons.Rounded.SportsBaseball,
                        isSelected = hobbiesChipState.value,
                        onChecked = {
                            hobbiesChipState.value = it
                        },
                        tintColor = Color(0xFF247BA0)
                    )
                    ImageChip(
                        imageVector = Icons.Rounded.CleaningServices,
                        isSelected = householdingChipState.value,
                        onChecked = {
                            householdingChipState.value = it
                        },
                        tintColor = Color(0xFF0AAEB9)
                    )
                    ImageChip(
                        imageVector = Icons.Rounded.MedicalServices,
                        isSelected = healthChipState.value,
                        onChecked = {
                            healthChipState.value = it
                        },
                        tintColor = Color(0xFFEAF6ED)
                    )




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

        Button(
            onClick = {  },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF25F5C)),
            modifier = Modifier.padding(top = 20.dp)
        ) {

            Text(
                text = "Save",
                color = White)
        }

    }
}
