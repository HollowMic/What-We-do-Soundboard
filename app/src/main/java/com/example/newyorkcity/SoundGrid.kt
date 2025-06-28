package com.example.newyorkcity

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SoundGrid() {

    val context = LocalContext.current
    val soundLibrary = remember { SoundLibrary() }
    val mediaController = remember { MediaController(context) }
    val storageBox = remember { StorageBox(context) }
    println("Loading sounds")
    val soundsInStorage = storageBox.loadSounds()
    println("After Loading sounds")
    for (sound in soundsInStorage) {
        println("For loop inside")
        soundLibrary.addSound(sound)
    }

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { mediaController.playSound(Sound("")) },
                containerColor = Color(255, 113, 103, 255)
            ) {
                Icon(contentDescription = "", painter = painterResource(id = R.drawable.baseline_stop_24))
            }
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                contentPadding = PaddingValues(10.dp),
            ) {
                items(soundLibrary.getLength()) {
                    val soundItem = soundLibrary.getSound(it)
                    if (soundItem != null) {
                        SoundButton(soundItem) {
                            mediaController.playSound(
                                soundItem
                            )
                        }
                    }
                }
//                item {
//                    SoundButton(Sound("Add Sound", 0)) {
//                        showBottomSheet = true
//                    }
//                }
                // Empty space below other buttons
                item {
                    var height = 100
                    val length = soundLibrary.getLength()
                    if (length % 3 == 0) {
                        height = 100
                    } else {
                        height = 200
                    }
                    Box(modifier = Modifier.padding(it).height(height.dp).fillMaxWidth().fillMaxSize().defaultMinSize(height.dp)) {}
                }
            }

        }

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {

                var result by remember { mutableStateOf<Uri?>(null) }
                val launcher = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) {
                    result = it
                }

                var name by remember { mutableStateOf("") }
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Column {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp, 0.dp),
                            value = name,
                            onValueChange = { name = it },
                            label = { Text("Name") }
                        )
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            onClick = { launcher.launch(arrayOf("*/*")) }
                        ) {
                            Text(text = "Upload MP3")
                        }
                        Text(text = result.toString())
                        if (result != null) {
                            Row(
                                horizontalArrangement = Arrangement.End
                            ) {
                                Button(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .padding(10.dp),
                                    onClick = {
                                        val newSound: Sound
                                        result?.let {
                                            newSound = Sound(name, uri = it)
                                            soundLibrary.addSound(newSound)
                                            storageBox.saveSound(newSound)
                                        }
                                        showBottomSheet = false
                                    }
                                ) {
                                    Text(text = "Add")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}