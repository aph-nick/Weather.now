package com.plcoding.weatherapp.presentation

import com.plcoding.weatherapp.domain.weather.WeatherData

data class WeatherState(
    val weatherDataPerDay: Map<Int, List<WeatherData>>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val currentDayIndex: Int = 0 // current day
)
