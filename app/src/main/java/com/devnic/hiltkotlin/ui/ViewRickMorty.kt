package com.devnic.hiltkotlin.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.devnic.hiltkotlin.model.Characters


@Composable
fun RickAndMortyApi(
) {
    val viewModel: MainViewModel = hiltViewModel()
    viewModel.getDataResult()
    val listCharacters = viewModel.characters.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            listCharacters.value.listCharacters.map {
                item {
                    ItemList(character = it)
                }
            }
        }
    }
}

@Composable
fun ButtonNav() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
            shape = CutCornerShape(4.dp)
        ) {
            Text(text = "Navigate", color = Color.White)
        }
    }
}

@Composable
fun ItemList(character: Characters) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
    ) {
        Card(
            border = BorderStroke(2.dp, MaterialTheme.colors.onSurface),
            elevation = 5.dp,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .padding(start = 45.dp, end = 45.dp, top = 5.dp)
                .height(200.dp)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .wrapContentSize()
                        .padding(start = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(character.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(text = "Name: ${character.name}")
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = "Specie: ${character.species}")
                    }
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(character.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        modifier = Modifier
                            .width(200.dp)
                            .height(100.dp)
                            .padding(all = 2.dp)
                            .clip(RoundedCornerShape(50.dp))
                    )
                }
                Text(text = "Origin ${character.location.name}")
            }
        }
    }
}