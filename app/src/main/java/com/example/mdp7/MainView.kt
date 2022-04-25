
import android.app.DatePickerDialog
import android.content.ContentValues
import android.util.Log
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
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
import com.example.mdp7.Transaction
import com.example.mdp7.components.ImageChip

import com.example.mdp7.TransactionViewModel



@Composable
fun MainView(){
    val db = Firebase.firestore

    var total by remember {
        mutableStateOf("")}

    var transactionName by remember {
        mutableStateOf("")
    }
    var transactionTotal by remember { mutableStateOf("") }

    val mContext = LocalContext.current
    val mYear: Int
    val mMonth: Int
    val mDay: Int


    val mCalendar = Calendar.getInstance()
    mYear = mCalendar.get(Calendar.YEAR)
    mMonth = mCalendar.get(Calendar.MONTH)
    mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()

    val transactionDate = remember { mutableStateOf("") }
    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            transactionDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
        }, mYear, mMonth, mDay
    )


    val transactionVM = viewModel<TransactionViewModel>(LocalContext.current as ComponentActivity)



    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your budget",
            style = MaterialTheme.typography.h4
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "New transaction",
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Text(text = "Name:")
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 15.dp)
                    .width(200.dp)
                    .height(40.dp),
                value = transactionName,
                onValueChange = { transactionName = it },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row() {
            Text(text = "Total:")
            OutlinedTextField(
                modifier = Modifier
                .padding(start = 15.dp)
                .width(200.dp)
                .height(40.dp),
                value = transactionTotal,
                onValueChange = { transactionTotal = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Black,
                    unfocusedBorderColor = Color.Black
                )

            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier.width(150.dp),

            onClick = {mDatePickerDialog.show()}) {
            Text(
                text = "Choose date",
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(

            onClick = {

                db
                    .collection("transactions")
                    .document(transactionName)
                    .set(Transaction(transactionTotal))

                transactionVM.addTransaction(Transaction(transactionTotal))


                db
                    .collection("transactions")
                    .document(transactionName)
                    .get()
                    .addOnSuccessListener {
                        total = it.get("transactionTotal").toString()
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

            },
            shape = RoundedCornerShape(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF25F5C)),
            modifier = Modifier.width(150.dp)
        )
        {

            Text(
                text = "Save",
                color = Color.White
            )
        }


        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Choose category",
            style = MaterialTheme.typography.h6
        )
        Row() {
            val groceriesChipState = remember {
                mutableStateOf(false)
            }
            val restaurantChipState = remember {
                mutableStateOf(false)
            }
            val transportChipState = remember {
                mutableStateOf(false)
            }
            val hobbiesChipState = remember {
                mutableStateOf(false)
            }
            val householdingChipState = remember {
                mutableStateOf(false)
            }
            val healthChipState = remember {
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

        transactionVM.transactions.value.forEach {
            Divider(thickness = 2.dp)
            Card(
                modifier = Modifier
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
                    ) {
                        Text(
                            text = transactionName,
                            color = Color(0xFF27303F),
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.width(170.dp))
                        Text(
                            text = total + "€",
                            color = Color(0xFF27303F),
                            fontWeight = FontWeight.Bold

                        )
                    }

                    Text(
                        text = "${transactionDate.value}",
                        color = Color(0xFF64748B)
                    )

                }

            }
        }
    }

    }

