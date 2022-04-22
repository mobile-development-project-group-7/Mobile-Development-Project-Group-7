package com.example.mdp7

import android.app.DatePickerDialog
import android.content.ContentValues
import android.util.Log
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.FontWeight


@Composable
fun TestMainForm(){
    val db = Firebase.firestore

    var total by remember {
        mutableStateOf("")}

    var TransactionName by remember {
        mutableStateOf("")
    }
    var TransactionTotal by remember { mutableStateOf("") }
    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int


    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()

    val TransactionDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            TransactionDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )


    val TransactionVM = viewModel<TransactionViewModel>(LocalContext.current as ComponentActivity)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = TransactionName,
            onValueChange = { TransactionName = it })

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(value = TransactionTotal,
            onValueChange ={TransactionTotal = it } ,
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),

        )
        Button(onClick = {
                mDatePickerDialog.show()
            }) {
                Text(text = "Choose date", color = Color.White)
            }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                db
                    .collection("transactions")
                    .document(TransactionName)
                    .set(Transaction(TransactionTotal))

                TransactionVM.addTransaction(Transaction(TransactionTotal))


                db
                    .collection("Transactions")
                    .document(TransactionName)
                    .get()
                    .addOnSuccessListener {
                        total = it.get("TransactionTotal").toString()
                       /* for (doc in it ) {
                            Log.d(
                                doc,
                                doc!!["TransactionTotal"].toString()
                            )
                        }*/
                    }
                    .addOnFailureListener { exception ->
                        Log.w(ContentValues.TAG, "Error getting documents.", exception)
                    }

            }) {
            Text(text = "Save")
        }
        }



        TransactionVM.transactions.value.forEach{
            Divider(thickness = 2.dp)
            Card(modifier = Modifier
                .border(2.dp, Color(0xFFF1F5F9))
                .width(335.dp)
                .height(69.dp)
            ) {

                Column(
                    modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.SpaceBetween
                ) {

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = TransactionName,
                            color= Color(0xFF27303F),
                        fontWeight= FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(170.dp))
                        Text(text = TransactionTotal + "€",
                            color= Color(0xFF27303F),
                            fontWeight= FontWeight.Bold
                            
                        )
                    }

                    Text(
                        text = "${TransactionDate.value}",
                        color= Color(0xFF64748B)
                    )

                }

            }
        }




        }









