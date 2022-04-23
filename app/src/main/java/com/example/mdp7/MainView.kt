
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
fun MainView(){
    Text(text = "Your budget")
    Text(text = "New transaction",
        style = MaterialTheme.typography.h6)

    Spacer(modifier = Modifier.height(10.dp))

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
}
