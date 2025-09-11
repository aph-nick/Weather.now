import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.weatherapp.presentation.WeatherViewModel

@Composable
fun DaySelectionButtons(viewModel: WeatherViewModel) {
    val state = viewModel.state

    val weatherDataSize = state.weatherDataPerDay?.size ?: 0
    val isLastDayButtonEnabled = state.currentDayIndex > 0
    val isNextDayButtonEnabled = state.currentDayIndex < weatherDataSize - 1

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = { viewModel.previousDay() },
            enabled = isLastDayButtonEnabled
        ) {
            Text("Last Day")
        }

        Button(
            onClick = { viewModel.nextDay() },
            enabled = isNextDayButtonEnabled
        ) {
            Text("Next Day")
        }
    }
}