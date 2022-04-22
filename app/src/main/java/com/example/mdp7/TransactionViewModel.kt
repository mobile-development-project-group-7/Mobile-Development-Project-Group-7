package com.example.mdp7

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TransactionViewModel: ViewModel() {

        var transactions = mutableStateOf(mutableListOf<Transaction>())

        fun addTransaction(transaction: Transaction){
            var newTransactions =  transactions.value.toMutableList()
            newTransactions.add(transaction)
            transactions.value = newTransactions
        }



}