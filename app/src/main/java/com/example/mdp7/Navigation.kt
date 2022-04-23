package com.example.mdp7

import MainView
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


const val LOGIN_ROUTE = "login"
const val REGISTRATION_ROUTE = "registration"
const val REMINDERS_ROUTE = "reminders"
const val SETTINGS_ROUTE = "settings"
const val HOME_ROUTE = "home"
const val STATISTICS_ROUTE = "statistics"

@Composable
fun Navigation(navController: NavHostController){
    val userVM = viewModel<UserViewModel>()


    NavHost(navController = navController, startDestination = LOGIN_ROUTE) {
        composable(route = LOGIN_ROUTE) { LoginView(userVM) }
        composable(route = REGISTRATION_ROUTE) { RegistrationApp() }
        composable(route = HOME_ROUTE) {MainView()}
        composable(route = STATISTICS_ROUTE) { StatisticsView() }
        composable(route = REMINDERS_ROUTE) { TestMainForm() }
        composable(route = SETTINGS_ROUTE) {SettingsView() }


    }
}