package com.devnic.hiltkotlin.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.devnic.hiltkotlin.R
import com.devnic.hiltkotlin.model.modelbd.NoteModel
import com.devnic.hiltkotlin.navigation.Destinations

@Composable
fun NoteList(navController: NavController) {
    val viewModel: NoteViewModel = hiltViewModel()
    val list by viewModel.listNote.observeAsState()
    Column(
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(all = 10.dp)
    ) {
        FloatingActionButton(
            onClick = {
                navController.navigate(Destinations.AddNote.route)
            },
            contentColor = MaterialTheme.colors.secondary,
            shape = RoundedCornerShape(16.dp),
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "Add Note",
                tint = Color.White,
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                list?.map { noteM ->
                    item {
                        CardNote(note = noteM)
                    }
                }
            }
        }
    }
}

@Composable
fun CardNote(note: NoteModel) {
    val viewModel: NoteViewModel = hiltViewModel()
    Card(
        modifier = Modifier
            .size(width = 300.dp, height = 100.dp)
            .padding(top = 10.dp), elevation = 10.dp,
        shape = MaterialTheme.shapes.medium,
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {

            val offset = Offset(5.0f, 10.0f)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    fontFamily = FontFamily.Monospace,
                    modifier = Modifier
                        .padding(end = 30.dp, top = 5.dp)
                        .drawBehind {
                            drawCircle(
                                color = Color.LightGray,
                                radius = this.size.minDimension
                            )
                        },
                    text = note.id.toString()
                )
                note.title?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 24.sp,
                            shadow = Shadow(
                                color = Color.LightGray,
                                offset = offset,
                                blurRadius = 3f
                            )
                        ),
                        fontFamily = FontFamily.Serif,
                    )
                }

            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.clickable {
                        viewModel.deleteNote(note)
                    }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_delete),
                        contentDescription = "Delete"
                    )
                    Text(text = "Eliminar")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_edit),
                        contentDescription = "Update"
                    )
                    Text(text = "Actualizar")
                }
            }
        }
    }
}

@Preview(showSystemUi = false, device = Devices.DEFAULT)
@Composable
fun ListviewP() {
    CardNote(NoteModel(1, "Nota 1", "Resumen"))
}



