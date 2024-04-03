package com.example.newyorkcity

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SoundButton(sound: Sound, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize().padding(0.dp, 0.dp)
    ) {
        Button(
            onClick = {
                onClick()
            },
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .padding(10.dp, 10.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            AutoResizedText(
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                text = sound.getName()
            )
        }
    }
}