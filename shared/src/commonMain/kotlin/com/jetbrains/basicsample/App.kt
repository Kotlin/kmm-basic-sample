package com.jetbrains.basicsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = greet(),
                modifier = Modifier.padding(8.dp)
            )

            val firstNumber = rememberTextFieldState(initialText = "")
            val secondNumber = rememberTextFieldState(initialText = "")

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TextField(
                    state = firstNumber,
                    placeholder = { Text("A") },
                    modifier = Modifier.width(100.dp),
                    lineLimits = TextFieldLineLimits.SingleLine,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
                Text(text = "+", modifier = Modifier.padding(4.dp))
                TextField(
                    state = secondNumber,
                    placeholder = { Text("B") },
                    modifier = Modifier.width(100.dp),
                    lineLimits = TextFieldLineLimits.SingleLine,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )

                val first = firstNumber.text.toString().toIntOrNull()
                val second = secondNumber.text.toString().toIntOrNull()
                Text(
                    text = if (first != null && second != null) {
                        "= ${Calculator.sum(first, second)}"
                    } else {
                        "= 🤔"
                    },
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

fun greet(): String {
    return Greeting().greeting()
}
