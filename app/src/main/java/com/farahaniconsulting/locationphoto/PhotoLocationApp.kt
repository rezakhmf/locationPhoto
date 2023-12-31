package com.farahaniconsulting.locationphoto

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.farahaniconsulting.locationphoto.ui.components.MapScreen
import com.farahaniconsulting.locationphoto.ui.locationPhoto.LocationPhotoScreen

@Composable
fun PhotoLocationApp (
    appState:  PhotoLocationAppState = rememberPhotoLocationAppState()
) {
    if (appState.isOnline) {
        NavHost(
            navController = appState.navController,
            startDestination = Screen.Home.route) {
            composable(Screen.Home.route) { navBackStackEntry ->
                LocationPhotoScreen()
            }
        }
    } else {
        OfflineDialog{
            appState.refreshOnline()
        }
    }
}

@Composable
fun OfflineDialog(
    onRetry: () -> Unit
){
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(R.string.connection_error_title)) },
        text = { Text(text = stringResource(R.string.connection_error_message)) },
        confirmButton = {
            TextButton(
                onClick = onRetry
            ) {
                Text(text = stringResource(R.string.retry_label))
            }
        })
}