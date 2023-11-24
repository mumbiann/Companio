// BottomNavBar.kt
package com.example.conversationcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavBar() {
    // Use Surface with a custom shape to create the bottom navigation bar
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),

    ) {
        // Row to arrange components horizontally
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Account icon
            Icon(
                Icons.Default.AccountCircle,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { /* Handle account icon click */ }
            )

            // Home icon
            Icon(
                Icons.Default.Home,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { /* Handle home icon click */ }
            )

            // Settings icon
            Icon(
                Icons.Default.Settings,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .clickable { /* Handle settings icon click */ }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavBar() {
    BottomNavBar()
}
