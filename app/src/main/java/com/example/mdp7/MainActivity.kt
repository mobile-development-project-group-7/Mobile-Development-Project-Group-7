package com.example.mdp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
<<<<<<< HEAD
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.mdp7.ui.theme.MDP7Theme
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
=======
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

>>>>>>> 796af3d03dc50efad0a8b15476dc72a529419ae5

import android.view.WindowManager
import androidx.compose.material.Icon
import androidx.compose.material.icons.rounded.Menu

class MainActivity : ComponentActivity() {

    companion object {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MDP7Theme {
<<<<<<< HEAD
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PieChart()
                }
=======

                MainScaffold()
>>>>>>> 796af3d03dc50efad0a8b15476dc72a529419ae5
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
                            Icon(Icons.Rounded.Menu, contentDescription = "Menu")
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

@Composable
fun PieChart(
    values: List<Float> = listOf(15f, 15f, 40f, 20f,5f,5f),
    colors: List<Color> = listOf(Color(0xFFF25F5C), Color(0xFF67C587), Color(0xFFFFE066),Color(
        0xFF247BA0), Color(0xFF0AAEB9),Color(0xFFEAF6ED)
    ),
    legend: List<String> = listOf(
        "groceries",
        "restraurant",
        "transport",
        "hobbies/entertaiment",
        "householding",
        "health"),
    size: Dp = 200.dp
) {

    // Sum of all the values
    val sumOfValues = values.sum()

    // Calculate each proportion value
    val proportions = values.map {
        it * 100 / sumOfValues
    }

    // Convert each proportions to angle
    val sweepAngles = proportions.map {
        360 * it / 100
    }

    Canvas(
        modifier = Modifier
            .size(size = size)
    ) {

        var startAngle = -90f

        for (i in sweepAngles.indices) {
            drawArc(
                color = colors[i],
                startAngle = startAngle,
                sweepAngle = sweepAngles[i],
                useCenter = true
            )
            startAngle += sweepAngles[i]
        }

    }

    Spacer(modifier = Modifier.height(32.dp))

    Column {
        for (i in values.indices) {
            DisplayLegend1(color = colors[i], legend = legend[i])
        }
    }

}

<<<<<<< HEAD
@Composable
fun DisplayLegend1(color: Color, legend: String) {

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier.width(16.dp),
            thickness = 4.dp,
            color = color
        )

        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = legend,
            color = Color.Black
        )
=======

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MainScaffold()
>>>>>>> 796af3d03dc50efad0a8b15476dc72a529419ae5
    }
}