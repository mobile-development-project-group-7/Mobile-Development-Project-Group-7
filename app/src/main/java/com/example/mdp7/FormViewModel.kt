package com.example.mdp7

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    var TransactionName by mutableStateOf("")
   /* var total by mutableStateOf("")*/

}