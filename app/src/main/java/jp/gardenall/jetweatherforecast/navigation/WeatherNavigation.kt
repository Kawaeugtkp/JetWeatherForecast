package jp.gardenall.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.gardenall.jetweatherforecast.screens.main.MainScreen
import jp.gardenall.jetweatherforecast.screens.main.MainViewModel
import jp.gardenall.jetweatherforecast.screens.search.SearchScreen
import jp.gardenall.jetweatherforecast.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name) {
        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController = navController)
        }
        composable(WeatherScreens.MainScreen.name) {
            val mainViewModel = hiltViewModel<MainViewModel>()
            MainScreen(navController = navController, mainViewModel)
        }
        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
    }
}