package com.farahaniconsulting.locationphoto.ui.locationPhoto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.ui.PhotoLocationViewModel
import com.farahaniconsulting.locationphoto.ui.common.UIState
import com.farahaniconsulting.locationphoto.ui.components.AddLocationDialog
import com.farahaniconsulting.locationphoto.ui.components.EditLocationDialog
import com.farahaniconsulting.locationphoto.ui.components.ListScreen
import com.farahaniconsulting.locationphoto.ui.components.MapScreen
import com.farahaniconsulting.locationphoto.ui.components.ShowError
import com.farahaniconsulting.locationphoto.ui.components.ShowLoading
import com.farahaniconsulting.locationphoto.ui.theme.BackgroundGrey

@Composable
fun LocationPhotoScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: PhotoLocationViewModel = hiltViewModel()
) {
    LocationPhotoContent(
        navController = navController,
        viewModel = viewModel
    )
}

@Composable
fun LocationPhotoContent(
    modifier: Modifier = Modifier,
    viewModel: PhotoLocationViewModel,
    navController: NavHostController,
) {
    val uiState: UIState<List<Location>> by viewModel.photoLocationState.collectAsStateWithLifecycle()
    var isAddDialogVisible by remember { mutableStateOf(false) }
    var isEditDialogVisible by remember { mutableStateOf(false) }
    var selectedLocation by remember { mutableStateOf<Location?>(null) }



    if (uiState.isLoading) {
        ShowLoading(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundGrey)
        )
    } else if (uiState.error?.isNotEmpty() == true) {
        ShowError(
            error = uiState.error,
            modifier = modifier
                .fillMaxSize()
                .background(BackgroundGrey)
        )
    } else {
        uiState.data?.let { locations ->

            AddLocationDialog(
                isDialogVisible = isAddDialogVisible,
                onDismiss = {
                    isAddDialogVisible = false
                },
                onAddLocation = { newLocation ->
                    viewModel.addLocation(newLocation)
                }
            )

            selectedLocation?.let { location ->
                EditLocationDialog(
                    isDialogVisible = isEditDialogVisible,
                    location = location,
                    onDismiss = {
                        isEditDialogVisible = false
                    },
                    onEditLocation = { newLocation ->
                        viewModel.editLocation(newLocation)
                    }
                )
            }
            Scaffold { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = innerPadding.calculateTopPadding())
                ) {

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        ListScreen(locations = locations) { editedLocation ->
                            selectedLocation = editedLocation
                            isEditDialogVisible = true
                        }
                        FloatingActionButton(
                            onClick = {
                                isAddDialogVisible = true
                            },
                            modifier = Modifier
                                .padding(16.dp)
                                .align(Alignment.TopEnd)
                        ) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Location")
                        }
                    }

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    ) {
                        MapScreen(locations = locations,
                            onAddLocation = {}
                            //TODO
                        )
                    }
                }
            }
        }
    }
}