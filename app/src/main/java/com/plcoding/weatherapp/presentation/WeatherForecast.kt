package com.plcoding.weatherapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.time.LocalDateTime

@Composable
fun WeatherForecast(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    state.weatherDataPerDay?.get(state.currentDayIndex)?.let { data ->
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        val listState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        val now = LocalDateTime.now()
        val roundedHour = if (now.minute < 30) now.hour else (now.hour + 1) % 24

        if (data.first().time.dayOfMonth == now.dayOfMonth) {
            coroutineScope.launch {
                val initialIndex = data.indexOfFirst { it.time.hour == roundedHour }
                if (initialIndex >= 0) {
                    listState.animateScrollToItem(index = initialIndex)
                }
            }
        }

        LazyRow(
            state = listState,
            content = {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        weatherData = weatherData,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        )
        }
    }
}