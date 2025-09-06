package com.plcoding.weatherapp.domain.weather

data class WeatherInfo(

    /// Weather Information for upcoming days
    // (Initially Int = 0 - today, 1 - tmrw, etc. - soon to be improved)
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
)
