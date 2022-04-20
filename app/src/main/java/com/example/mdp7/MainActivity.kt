package com.example.mdp7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MDP7Theme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PieChart()
                }
            }
        }
    }
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
    }
}