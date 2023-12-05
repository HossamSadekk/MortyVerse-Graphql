package com.example.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun DetailsTextSection(sectionTitle:String,detailsText:String){
    Row(modifier = Modifier.padding(5.dp)){
        Text(
            text = "$sectionTitle: ",
            style = MaterialTheme.typography.headlineSmall,
            color = MaterialTheme.colorScheme.inversePrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = detailsText,
            color = MaterialTheme.colorScheme.inversePrimary,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}