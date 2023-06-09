package com.devnic.hiltkotlin.navigation

sealed class Destinations(
    val route: String
) {
    object NotePads : Destinations("NotePads")
    object AddNote : Destinations("AddNote")
    object RickMorty : Destinations("RickMorty")
    object MainUi : Destinations("MainUi")
    object TegInfo : Destinations("TegInfo")
    object GoogleMaps : Destinations("GoogleMaps")
}
