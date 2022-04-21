package com.example.mdp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.example.mdp7.ui.theme.MDP7Theme
import androidx.compose.runtime.*
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase



import androidx.navigation.compose.rememberNavController


import android.view.WindowManager

class MainActivity : ComponentActivity() {

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MDP7Theme {

                MainScaffold()
            }
        }
    }

    @Composable
    fun MainScaffold() {

        val navController = rememberNavController()

        val userVM = viewModel<UserViewModel>()


        val context = LocalContext.current
        val expanded = remember { mutableStateOf(false) }

        val scaffoldState = rememberScaffoldState()
        Scaffold(
            scaffoldState = scaffoldState,
            content = {
                Navigation(navController)
                Column( verticalArrangement = Arrangement.SpaceAround){


                }

            },
            topBar = {
                TopAppBar(title = { Text(userVM.username.value) },
                    backgroundColor = Color.White,
                    contentColor = Color.Black,
                    actions = {
                        IconButton(
                            onClick = {
                                expanded.value = true
                            }

                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "image",
                                tint = Color.Black,
                            )
                        }
                        DropdownMenu(
                            expanded = expanded.value ,
                            onDismissRequest = { expanded.value  = false },
                        ) {
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Log in",
                                    modifier = Modifier.clickable{navController.navigate(LOGIN_ROUTE)}
                                )

                            }
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Register",
                                    modifier = Modifier.clickable{navController.navigate(REGISTRATION_ROUTE)}
                                )
                            }
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Home",
                                    modifier = Modifier.clickable{navController.navigate(HOME_ROUTE)}
                                )
                            }
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Statistics",
                                    modifier = Modifier.clickable{navController.navigate(
                                        STATISTICS_ROUTE)}
                                )
                            }
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Reminders",
                                    modifier = Modifier.clickable{navController.navigate(REMINDERS_ROUTE)}
                                )
                            }
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Settings",
                                    modifier = Modifier.clickable{navController.navigate(SETTINGS_ROUTE)}
                                )
                            }
                            DropdownMenuItem(onClick = { expanded.value  = false }) {
                                Text(text = "Log out",
                                    modifier = Modifier.clickable{userVM.logoutUser()}
                                )
                            }
                        }

                    })
            },
        )
    }



    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainScaffold()
    }
}