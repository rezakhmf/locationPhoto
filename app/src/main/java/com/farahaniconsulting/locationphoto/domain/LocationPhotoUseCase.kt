package com.farahaniconsulting.locationphoto.domain

import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepository
import com.farahaniconsulting.locationphoto.util.ResultData
import javax.inject.Inject

class LocationPhotoUseCase @Inject constructor(
    private val locationPhotoRepository: LocationPhotoRepository
) {
    suspend fun getPhotoLocations(): ResultData<List<Location>?> {
        locationPhotoRepository.getDefaultLocations()?.let { locations ->
            return ResultData.Success(locations)
        }
        return ResultData.DoNothing
    }

    suspend fun saveLocation(name: String, latitude: Double, longitude: Double) {
        locationPhotoRepository.saveCustomLocation(
            name = name,
            latitude = latitude,
            longitude = longitude
        )
    }

    suspend fun updateLocation(id: Long, name: String, latitude: Double, longitude: Double) {
        locationPhotoRepository.updateLocation(
            id = id,
            name = name,
            latitude = latitude,
            longitude = longitude
        )
    }
}