package com.example.mdp7

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp




@Composable
fun StatisticsView(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        Spacer(modifier = Modifier.height(25.dp))
        PieChart()
    }
}



@Composable
fun PieChart(
    values: List<Float> = listOf(15f, 15f, 40f, 20f,5f,5f),
    colors: List<Color> = listOf(
        Color(0xFFF25F5C), Color(0xFF67C587), Color(0xFFFFE066),
        Color(0xFF247BA0), Color(0xFF0AAEB9), Color(0xFFEAF6ED)
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
