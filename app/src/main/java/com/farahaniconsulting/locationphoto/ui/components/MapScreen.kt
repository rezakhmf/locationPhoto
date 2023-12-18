package com.farahaniconsulting.locationphoto.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen(
    locations : List<Location>?,
    //onLocationSelected: (Location) -> Unit,
    onAddLocation: () -> Unit
) {
    var initialLocation = LatLng(0.0, 0.0)
    locations?.first()?.let { location ->
        initialLocation = LatLng(
            location.latitude,
            location.longitude)
    }

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(initialLocation, 1f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
            locations?.forEach { location ->
                Marker(
                    state = MarkerState(position = LatLng(
                        location.latitude,
                        location.longitude)),
                    title = location.name,
                    snippet = location.notes
                )

            }
    }
}

