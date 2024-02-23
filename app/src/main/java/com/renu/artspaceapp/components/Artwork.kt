package com.renu.artspaceapp.components

import androidx.compose.runtime.mutableStateOf
import com.renu.artspaceapp.R

data class Artwork(
    val imageResourceId: Int, //Resource id of artworl image
    val title: String,
    val artist: String,
    val year: String
)
val currentIndex = mutableStateOf(0)

val artworkList = listOf(

    Artwork(
        imageResourceId = R.drawable.artwork_1,
        title = "An Iconic Image",
        artist = "Vincent van Gogh",
        year = "2024"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_2,
        title = "The Horse's Majesty",
        artist = "Pablo Picasso",
        year = "(2023)"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_3,
        title = "SThe Beauty of Girlhood",
        artist = "Jackson Pollock",
        year = "(2022)"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_4,
        title = " The Protector of Dharma",
        artist = "Henri Matisse",
        year = "(2021)"
    ),
    Artwork(
        imageResourceId = R.drawable.artwork_5,
        title = "Nature's Infinite Beauty",
        artist = "Edward Hopper",
        year = "(2020)"
    )
)