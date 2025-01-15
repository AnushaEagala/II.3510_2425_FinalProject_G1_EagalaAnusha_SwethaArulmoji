package com.example.newsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.newsapp.HomePage
import com.example.newsapp.LoginScreen
import com.example.newsapp.SignUpScreen
import com.example.newsapp.WelcomePage
import com.example.newsapp.ProfileScreen
import com.example.newsapp.ui.theme.ConnectionsScreen
import com.example.newsapp.ui.theme.ScreenTimeScreen
import com.example.newsapp.AuthViewModel

@Composable
fun AppNavigation(navController: NavHostController, authViewModel: AuthViewModel) {
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") {
            WelcomePage(
                onNavigateToLogin = { navController.navigate("login") }
            )
        }
        composable("login") {
            LoginScreen(
                onNavigateToHome = { navController.navigate("home") },
                onNavigateToSignUp = { navController.navigate("signup") },
                authViewModel = authViewModel
            )
        }
        composable("signup") {
            SignUpScreen(
                onNavigateToLogin = { navController.navigate("login") },
                authViewModel = authViewModel
            )
        }
        composable("home") {
            HomePage(
                onNavigateToConnectionsGraph = { navController.navigate("connections") },
                onNavigateToScreenTimeGraph = { navController.navigate("screenTime") },
                onNavigateToProfile = { navController.navigate("profile") }
            )
        }

        composable("profile") {
            ProfileScreen()
        }

        composable("connections") {
            ConnectionsScreen()
        }

        composable("screenTime") {
            ScreenTimeScreen()
        }
    }
}
