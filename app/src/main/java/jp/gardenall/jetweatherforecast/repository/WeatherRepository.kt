package jp.gardenall.jetweatherforecast.repository

import android.util.Log
import jp.gardenall.jetweatherforecast.data.DataOrException
import jp.gardenall.jetweatherforecast.model.Weather
import jp.gardenall.jetweatherforecast.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(cityQuery: String): DataOrException<Weather, Boolean, Exception> {
        var response = try {
            api.getWeather(query = cityQuery)
        } catch (e: Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }
}