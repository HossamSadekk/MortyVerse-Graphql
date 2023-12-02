package com.example.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.request.ImageRequest
import com.example.domain.model.Characters
import com.example.presentation.theme.DpDimensions
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.coil.CoilImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CharacterRow(
    character: Characters,
    onDetailClick: (id: String) -> Unit = {},
) {
    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.primary
        ),
        shadowElevation = 3.dp,
        shape = RoundedCornerShape(DpDimensions.Normal),
        onClick = { onDetailClick(character.id) },
        modifier = Modifier.fillMaxWidth().padding(5.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        val color = when (character.status) {
            "Alive" -> Color.Green
            "Dead" -> Color.Red
            else -> Color.Gray
        }
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            ImageCard(
                character.image,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(7.dp)
                    .height(110.dp)
                    .width(110.dp)
                    .clip(
                        RoundedCornerShape(16.dp)
                    )
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.fillMaxWidth().height(120.dp)){
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = character.name,
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = character.gender?:"Unknown",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = character.species,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(color = color, shape = CircleShape)
                    )
                    Text(text = character.status)
                }
            }

        }
    }
}

@Composable
fun ImageCard(
    imageLink: String,
    modifier: Modifier
) {
    CoilImage(
        modifier = modifier,
        imageRequest =
        ImageRequest
            .Builder(LocalContext.current)
            .data(imageLink)
            .crossfade(true)
            .build(),
        alignment = Alignment.Center,
        loading = {
            // Text(text = "Loading...")
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val indicator = createRef()
                CircularProgressIndicator(
                    modifier = Modifier.constrainAs(indicator) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
                )
            }
        },
        circularReveal = CircularReveal(
            duration = 300,
        ),
    )
}