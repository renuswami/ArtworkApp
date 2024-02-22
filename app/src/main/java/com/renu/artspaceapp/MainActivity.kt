package com.renu.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.renu.artspaceapp.components.Artwork
import com.renu.artspaceapp.components.artworkList
import com.renu.artspaceapp.components.currentIndex
import com.renu.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceLayout(
                        artworkList = artworkList,
                        currentIndex = currentIndex,
                        onNextClicked= { onNextClicked() },
                        onPreviousClicked = { onPreviousClicked() }
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceLayout(
    artworkList: List<Artwork>,
    currentIndex: Int,
    onNextClicked:() -> Unit,
    onPreviousClicked: () -> Unit,
) {
    val currentArtwork = artworkList[currentIndex]

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .border(
                BorderStroke(1.dp, Color.Gray)
            )
    ) {
        Image(
            painter = painterResource(id = currentArtwork.imageResourceId),
            contentDescription = "Artwork Image",
            modifier = Modifier
                .wrapContentSize()
                .size(280.dp)
        )
        Spacer(modifier = Modifier.height(64.dp))

        // Information about the artwork
        Column(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text(text = currentArtwork.title)
            Text(text = currentArtwork.artist)
            Text(text = currentArtwork.year)
        }

        Spacer(modifier = Modifier.height(64.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Other elements (buttons)
            Button(
                onClick = { onPreviousClicked()},
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { onNextClicked() },
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewArtSpaceApp() {
    ArtSpaceAppTheme {
        ArtSpaceLayout(
            artworkList = artworkList,
            currentIndex = currentIndex,
            onNextClicked= { onNextClicked() },
            onPreviousClicked = { onPreviousClicked() }
        )
    }
}

fun onNextClicked() {
    currentIndex = (currentIndex + 1) % artworkList.size
}

fun onPreviousClicked() {
    currentIndex = (currentIndex - 1 + artworkList.size) % artworkList.size
}
