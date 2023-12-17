package com.farahaniconsulting.locationphoto.ui

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.domain.LocationPhotoUseCase
import com.farahaniconsulting.locationphoto.ui.common.UIState
import com.farahaniconsulting.locationphoto.util.ResultData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoLocationViewModel  @Inject constructor(
    private val useCase: LocationPhotoUseCase
) : ViewModel() {

    private var _photoLocationState: MutableStateFlow<UIState<List<Location>>> =
        MutableStateFlow(UIState(isLoading = true))

    val photoLocationState: StateFlow<UIState<List<Location>>> =
        _photoLocationState.asStateFlow().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = UIState(isLoading = true)
        )
    init {
        viewModelScope.launch {
            fetchLocations()
        }
    }

    private suspend fun fetchLocations() {
        when(val result = useCase.getPhotoLocations()) {
            is ResultData.Success -> _photoLocationState.value =
                UIState(data = result.data)

            is ResultData.Loading -> _photoLocationState.value =
                UIState(isLoading = true)

            is ResultData.DoNothing -> {}
        }
    }

    fun addLocation(location: Location) {
       viewModelScope.launch {
           useCase.saveLocation(location)
           fetchLocations()
       }
    }


    fun editLocation(newLocation: Location) {
        viewModelScope.launch {
            useCase.updateLocation(newLocation)
            fetchLocations()
        }

    }
}