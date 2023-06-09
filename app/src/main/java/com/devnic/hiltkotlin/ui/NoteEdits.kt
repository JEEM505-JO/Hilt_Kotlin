package com.devnic.hiltkotlin.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devnic.hiltkotlin.database.StateNoteView
import com.devnic.hiltkotlin.database.StateUi
import com.devnic.hiltkotlin.model.modelbd.NoteModel
import com.devnic.hiltkotlin.navigation.Destinations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun NoteEdits(state: StateUi) {
    if (state.isSuccess) {
        state.onNavNoteList
    }
    Card(
        modifier =
        Modifier
            .padding(all = 10.dp)
            .padding()
            .fillMaxWidth()
            .fillMaxHeight(),
        elevation = 5.dp,
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
        ) {
            val inputTitle = remember { mutableStateOf(TextFieldValue("")) }
            val inputContent = remember { mutableStateOf(TextFieldValue("")) }

            TextField(
                value = state.title,
                onValueChange = {
                    if (it.length <= 20) {
                        state.onChangeTitle.invoke(it)
                    }
                },
                placeholder = {
                    Text(
                        fontFamily = FontFamily.Serif,
                        text = "Ingresa un titulo"
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Black,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = FontFamily.Serif
                ),
            )
            TextField(
                value = state.resume, onValueChange = state.onChangeResume,
                placeholder = { Text(text = "Contenido") },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.Gray,
                    disabledTextColor = Color.Transparent,
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth(),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )

            )
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Button(
                    onClick = {
                        state.insert()
                    },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
                ) {
                    Text(text = "Guardar", color = Color.White)
                }
            }

        }
    }


}

