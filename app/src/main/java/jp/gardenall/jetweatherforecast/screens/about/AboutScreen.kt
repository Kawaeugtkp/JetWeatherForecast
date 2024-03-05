package jp.gardenall.jetweatherforecast.screens.about

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import jp.gardenall.jetweatherforecast.R
import jp.gardenall.jetweatherforecast.widgets.WeatherAppBar

@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        topBar = {
            WeatherAppBar(
                title = "About",
                icon = Icons.Default.ArrowBack,
                isMainScreen = false,
                navController = navController
            ) {
                navController.popBackStack()
            }
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it.calculateTopPadding())
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, 
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.about_app),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = stringResource(id = R.string.api_used),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Light
                )
            }
        }
    }
}