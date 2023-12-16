package com.farahaniconsulting.locationphoto.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location

@Composable
fun ListScreen(
    locations : List<Location>,
    //onLocationSelected: (Location) -> Unit
) {

    LazyColumn {
        items(locations) { location ->
            LocationItem(location = location)
        }
    }
}

@Composable
fun LocationItem(location: Location) {
    Column(
        modifier = androidx.compose.ui.Modifier.padding(16.dp)
    ) {
        Text(text = "Name: ${location.name}")
        Text(text = "Latitude: ${location.latitude}")
        Text(text = "Longitude: ${location.longitude}")
    }
}

