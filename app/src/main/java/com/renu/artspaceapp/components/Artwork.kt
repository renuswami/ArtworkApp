package com.renu.artspaceapp.components

import com.renu.artspaceapp.R

data class Artwork(
    val imageResourceId: Int, //Resource id of artworl image
    val title: String,
    val artist: String,
    val year: String
)
var currentIndex = 4

val artworkList = listOf(

    Artwork(
        imageResourceId = R.drawable.artwork_1,
        title = "artwork 1",
        artist = "renu swami",
        year = "2024"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_2,
        title = "artwork 2",
        artist = "anshu swami",
        year = "2023"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_3,
        title = "artwork 3",
        artist = "Dheeraj swami",
        year = "2022"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_4,
        title = "artwork 4",
        artist = "ram",
        year = "2022"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_5,
        title = "artwork 5",
        artist = "honey",
        year = "2022"
    )
)