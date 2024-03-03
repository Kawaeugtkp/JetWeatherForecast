package jp.gardenall.jetweatherforecast.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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