package com.example.mdp7

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.*

@Composable
fun RemindersView(){

    Card(
        modifier = Modifier
            .padding(20.dp),
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.Black),
        elevation = 2.dp
    ) {

        Text(
            text="This function is available with subscription only for 10€ per month",
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
    }

    val transactionVM = viewModel<TransactionViewModel>(LocalContext.current as ComponentActivity)




}