package com.devnic.hiltkotlin.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.devnic.hiltkotlin.R
import com.devnic.hiltkotlin.navigation.Destinations


@Composable
fun MainUi(
    navigation: NavController
) {
    Column {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "App kotlin for android", fontSize = 25.sp, fontFamily = FontFamily.Serif)
            Text(
                text = "Aplicacion realizada con el objetivo de mostrar las mas " +
                        "actuales practicas de codificacion y arquitectura en el " +
                        "mundo del desarrollo nativo android",
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center
            )
        }
        val isExpanded by remember {
            mutableStateOf(false)
        }
        val gradualColor by animateColorAsState(
            if (isExpanded) Color.Blue else Color.White
        )
        Column(modifier = Modifier.padding(top = 5.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                //card Number one
                Card(
                    Modifier
                        .size(width = 150.dp, height = 150.dp)
                        .padding(start = 20.dp),
                    elevation = 5.dp,
                    shape = MaterialTheme.shapes.medium,
                    border = BorderStroke(2.dp, color = gradualColor)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxHeight()
                            .clickable { navigation.navigate(Destinations.TegInfo.route) },
                    ) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            Text(
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .drawBehind {
                                        drawCircle(
                                            color = Color.LightGray,
                                            radius = this.size.minDimension
                                        )
                                    },
                                text = "1"
                            )
                        }
                        Text(
                            text = "Kotlin",
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Tegnologias utilizadas",
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.android_dev),
                            contentDescription = "Developer",
                            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                        )
                    }
                }

//card Number two
                Card(
                    Modifier
                        .size(width = 150.dp, height = 150.dp)
                        .padding(end = 20.dp),
                    elevation = 5.dp,
                    shape = MaterialTheme.shapes.medium,
                    border = BorderStroke(2.dp, color = gradualColor)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxHeight()
                            .clickable {
                                navigation.navigate(Destinations.RickMorty.route)
                            },
                    ) {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                            Text(
                                fontFamily = FontFamily.Monospace,
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .drawBehind {
                                        drawCircle(
                                            color = Color.LightGray,
                                            radius = this.size.minDimension
                                        )
                                    },
                                text = "2"
                            )
                        }
                        Text(
                            text = "Rick and Morty",
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )
                        Text(
                            text = "Api Rest",
                            fontFamily = FontFamily.Serif,
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Image(
                            painter = painterResource(id = R.drawable.rick_morty_logo),
                            contentDescription = "Api logo",
                            modifier = Modifier
                                .clip(RoundedCornerShape(15.dp))
                                .size(width = 100.dp, height = 50.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.api_logo),
                            contentDescription = "Api logo",
                            modifier = Modifier.clip(RoundedCornerShape(15.dp))
                        )
                    }
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
        ) {
            //card Number three
            Card(
                Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(start = 20.dp),
                elevation = 5.dp,
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(2.dp, color = gradualColor)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable {
                            navigation.navigate(Destinations.NotePads.route)
                        },
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        Text(
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = Color.LightGray,
                                        radius = this.size.minDimension
                                    )
                                },
                            text = "3"
                        )
                    }
                    Text(
                        text = "Block de notas",
                        fontFamily = FontFamily.Serif,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Base de datos local",
                        fontFamily = FontFamily.Serif,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.notepad),
                        contentDescription = "Api logo",
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .size(width = 100.dp, height = 50.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.room_logo),
                        contentDescription = "Api logo",
                        modifier = Modifier.clip(RoundedCornerShape(15.dp))
                    )
                }
            }

//card Number four
            Card(
                Modifier
                    .size(width = 150.dp, height = 150.dp)
                    .padding(end = 20.dp),
                elevation = 5.dp,
                shape = MaterialTheme.shapes.medium,
                border = BorderStroke(2.dp, color = gradualColor)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .clickable {
                             navigation.navigate(Destinations.GoogleMaps.route)
                        },
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                        Text(
                            fontFamily = FontFamily.Monospace,
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .drawBehind {
                                    drawCircle(
                                        color = Color.LightGray,
                                        radius = this.size.minDimension
                                    )
                                },
                            text = "4"
                        )
                    }
                    Text(
                        text = "Google Maps",
                        fontFamily = FontFamily.Serif,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "Google api",
                        fontFamily = FontFamily.Serif,
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Image(
                        painter = painterResource(id = R.drawable.googlemaps),
                        contentDescription = "Api logo",
                        modifier = Modifier
                            .clip(RoundedCornerShape(15.dp))
                            .size(width = 150.dp, height = 150.dp)
                    )
                }
            }
        }
        val composabl1 by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.android_jetpack))
        LottieAnimation(composition = composabl1)
    }
}


