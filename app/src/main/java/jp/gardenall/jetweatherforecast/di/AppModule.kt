package jp.gardenall.jetweatherforecast.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.gardenall.jetweatherforecast.data.WeatherDao
import jp.gardenall.jetweatherforecast.data.WeatherDatabase
import jp.gardenall.jetweatherforecast.network.WeatherApi
import jp.gardenall.jetweatherforecast.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
// この辺（AppModuleやメソッド名）は書いた時には使用されていない風になるけど、
// 一度ビルドした際に自動生成されるコードによって使用されるので未使用状態でなくなる
class AppModule {
    @Singleton
    @Provides
    fun provideWeatherDao(weatherDatabase: WeatherDatabase): WeatherDao
    = weatherDatabase.weatherDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): WeatherDatabase
    = Room.databaseBuilder(
        context,
        WeatherDatabase::class.java,
        "weather_database"
    ).fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideOpenWeatherApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}