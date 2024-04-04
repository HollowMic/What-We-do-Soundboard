package com.example.newyorkcity

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.newyorkcity.ui.theme.NewYorkCityTheme
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewYorkCityTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val requestPermissionLauncher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
                        if (isGranted) {
                            // Permission granted, handle accordingly
                            // For example, you can proceed with file operations here
                        } else {
                            // Permission denied, handle accordingly
                        }
                    }

                    Column {
                        Button(onClick = { requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE) }) {
                            Text(text = "Request")
                        }
                        SoundGrid()
                    }

                }
            }
        }
    }
}
