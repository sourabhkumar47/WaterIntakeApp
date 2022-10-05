package com.example.waterintakeapp_state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        // Changes to count are now tracked by Compose
        var count by remember { mutableStateOf(0) }

        if (count > 0) {
            var showtask by remember { mutableStateOf(true) }
            if (showtask) {
                WellnessTaskItem(
                    taskName = "Have you taken 15 min walk today?",
                    onClose = {showtask = false }
                )
            }
            // This text is present if the button has been clicked
            // at least once; absent otherwise
            Text("You've had ${count} glasses.")
        }

        Button(
            onClick = { count++ },
//            Modifier.padding(top = 8.dp),
            enabled = count < 10,
            shape = RoundedCornerShape(24.dp)
        ) {
            Text("Add one")
        }
    }

}