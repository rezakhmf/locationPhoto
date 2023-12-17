package com.farahaniconsulting.locationphoto.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.farahaniconsulting.locationphoto.R
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location

@Composable
fun EditLocationDialog(
    isDialogVisible: Boolean,
    onDismiss: () -> Unit,
    location: Location? = null,
    onEditLocation: (Location) -> Unit
) {
    var newLocationName by remember { mutableStateOf(location?.name ?: "") }
    var newLocationLat by remember { mutableStateOf(location?.latitude.toString() ?: "") }
    var newLocationLng by remember { mutableStateOf(location?.longitude.toString() ?: "") }
    var newLocationNotes by remember { mutableStateOf( "") }

    if (isDialogVisible) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "Add New Location")
            },
            text = {
                Column {
                    TextField(
                        value = newLocationName,
                        onValueChange = {
                            newLocationName = it
                        },
                        label = {
                            Text(text = "Location Name")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    TextField(
                        value = newLocationLat,
                        onValueChange = {
                            newLocationLat = it
                        },
                        label = {
                            Text(text = "Latitude")
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    TextField(
                        value = newLocationLng,
                        onValueChange = {
                            newLocationLng = it
                        },
                        label = {
                            Text(text = "Longitude")
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    TextField(
                        value = newLocationNotes,
                        onValueChange = {
                            newLocationNotes = it
                        },
                        label = {
                            Text(text = "Notes")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        if (location != null) {
                            onEditLocation(
                                Location(
                                    id = location.id,
                                    name = newLocationName,
                                    latitude = newLocationLat.toDouble(),
                                    longitude = newLocationLng.toDouble(),
                                    notes = newLocationNotes
                                )
                            )
                        }

                        onDismiss()
                    },
                ) {
                    Text(text = stringResource(R.string.update))
                }
            },
            dismissButton = {
                Button(
                    onClick = {
                        onDismiss()
                    },
                ) {
                    Text(text = stringResource(R.string.cancel))
                }
            }
        )
    }
}
