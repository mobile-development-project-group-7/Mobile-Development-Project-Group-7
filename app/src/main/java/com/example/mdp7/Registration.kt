package com.example.mdp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mdp7.ui.theme.MDP7Theme
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



@Composable
fun RegistrationApp() {
    var email by remember{
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.budgettracker),
            contentDescription = "Logo",
            modifier = Modifier
                .width(250.dp)
                .height(70.dp)
                .padding(bottom = 20.dp)
        )
        Text (
            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp),
            text = "Enter your email")

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black))

        Text (
            modifier = Modifier.padding(bottom = 10.dp, top = 10.dp),
            text = "Enter your password")

        OutlinedTextField(

            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),

            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Black,
                unfocusedBorderColor = Color.Black)
        )
        OutlinedButton(
            onClick = { Firebase.auth.createUserWithEmailAndPassword(email,password)},
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .defaultMinSize(
                    minWidth = 120.dp,
                    minHeight = 35.dp
                )
                .padding(top = 50.dp)


        ) {
            Text(
                "Create account",
                style = MaterialTheme.typography.body2,
                color = Color.Black
            )
        }

    }
}


