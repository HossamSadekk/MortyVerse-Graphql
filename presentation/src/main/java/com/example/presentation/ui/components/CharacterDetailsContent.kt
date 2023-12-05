package com.example.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.presentation.R
import com.example.presentation.ui.CharacterDetails.CharacterDetailsState

@Composable
fun CharacterDetailsContent(
    uiState: CharacterDetailsState
) {
    val characterDetails = uiState.characterDetails
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        state = lazyListState,
        contentPadding = PaddingValues(bottom = 90.dp)
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
                contentAlignment = Alignment.Center

            ) {
                ImageCard(
                    characterDetails.image,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(150.dp)
                        .clip(
                            CircleShape
                        )
                )

            }
        }


        item {
            DetailsTextSection("Name", characterDetails.name)
            DetailsTextSection("Gender", characterDetails.gender)
            DetailsTextSection("Status", characterDetails.status)
            DetailsTextSection("Species", characterDetails.species)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Episodes:",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }

        items(characterDetails.episodes.size) { episode ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.episode),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(6.dp))
                characterDetails.episodes[episode]?.let {
                    Column {
                        Text(text = it.air_date)
                        Text(text = it.name, fontWeight = FontWeight.Bold)
                    }
                }

            }

        }


    }
}