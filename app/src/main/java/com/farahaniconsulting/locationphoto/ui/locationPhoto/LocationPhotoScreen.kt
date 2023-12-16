package com.farahaniconsulting.locationphoto.ui.locationPhoto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.ui.PhotoLocationViewModel
import com.farahaniconsulting.locationphoto.ui.common.UIState
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
    val uiState: UIState<List<Location>> by viewModel.photoLocationState.collectAsStateWithLifecycle()

    LocationPhotoContent(
        navController = navController,
        uiState = uiState
    )

}

@Composable
fun LocationPhotoContent(
    modifier: Modifier = Modifier,
    uiState: UIState<List<Location>>,
    navController: NavHostController,
) {
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
        uiState.data?.let {locations ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    ListScreen(locations = locations)
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                ) {
                    MapScreen(locations = locations,
                        onAddLocation = {}
                        //    onLocationSelected = ()
                    )
                }
            }
        }
    }
}