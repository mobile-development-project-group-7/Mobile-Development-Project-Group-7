package com.example.mdp7.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.ContentAlpha.medium
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mdp7.ui.theme.Shapes

@Composable
fun TransactionTypeChip(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = DarkGray
)
{
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else LightGray,
                shape = Shapes.medium
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = Shapes.medium
            )
            .clip(shape = Shapes.medium)
            .clickable {
                onChecked(!isSelected)
            }
            .padding(4.dp)
    ) {
        Text(
            text = text,
            color = if (isSelected) White else Black
        )
    }
}

@Composable
fun ImageChip(
    imageVector: ImageVector,
    isSelected: Boolean,
    onChecked: (Boolean) -> Unit,
    tintColor: Color
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                vertical = 1.dp,
                horizontal = 2.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) Black else tintColor,
                shape = Shapes.medium
            )
            .background(
                color = if (isSelected) tintColor else Transparent,
                shape = Shapes.medium
            )
            .clip(shape = Shapes.medium)
            .clickable {
                onChecked(!isSelected)
            }
            .padding(2.dp)
    ) {
        Icon(imageVector = imageVector,
            tint =   if (isSelected) Black else Color(0xFF484848),
            contentDescription = null
        )
    }
}


