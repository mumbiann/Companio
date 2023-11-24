// TopNavBar.kt
package com.example.conversationcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TopNavBar(title: String) {
    // Use Surface with a custom shape to create the top navigation bar
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .clip(MaterialTheme.shapes.medium)
            .padding(16.dp),

    ) {
        // Row to arrange components horizontally
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Backward navigation arrow
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.padding(8.dp)
            )

            // Title
            Text(
                text = title,
                modifier = Modifier.padding(8.dp),
                fontWeight = FontWeight.Bold,

            )
        }
    }
}
