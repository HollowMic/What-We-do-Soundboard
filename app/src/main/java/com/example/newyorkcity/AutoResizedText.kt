package com.example.newyorkcity

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun AutoResizedText(
    text: String,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    color: Color = style.color
) {
    var resizedTextStyle by remember { mutableStateOf(style) }

    Text(
        text = text,
        color = color,
        textAlign = textAlign,
        modifier = modifier,
        style = resizedTextStyle,
        onTextLayout = { result ->
            if(result.didOverflowHeight || result.didOverflowWidth) {
                resizedTextStyle = resizedTextStyle.copy(
                    fontSize = resizedTextStyle.fontSize * 0.95
                )
            }
        }
    )
}