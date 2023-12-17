package com.farahaniconsulting.locationphoto.domain

import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.entity.asDomainModel
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepository
import com.farahaniconsulting.locationphoto.util.ResultData
import javax.inject.Inject

class LocationPhotoUseCase @Inject constructor(
    private val locationPhotoRepository: LocationPhotoRepository
) {
    suspend fun getPhotoLocations(): ResultData<List<Location>?> {
        //locationPhotoRepository.getDefaultLocations()?
        locationPhotoRepository.getAllLocations().asDomainModel().let { locations ->
            return ResultData.Success(locations)
        }
    }

    suspend fun saveLocation(location: Location) {
        locationPhotoRepository.saveCustomLocation(
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude
        )
    }

    suspend fun updateLocation(location: Location) {
        locationPhotoRepository.updateLocation(
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude
        )
    }
}