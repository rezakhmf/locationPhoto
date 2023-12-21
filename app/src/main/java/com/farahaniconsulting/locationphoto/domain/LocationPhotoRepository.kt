package com.farahaniconsulting.locationphoto.domain

import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity

interface LocationPhotoRepository {
    suspend fun getDefaultLocations(): List<Location>?
    suspend fun getAllLocations(): List<PhotoLocationEntity>
    suspend fun saveCustomLocation(
        name: String,
        latitude: Double,
        longitude: Double,
        notes: String
    )

    suspend fun updateLocation(
        id: Long,
        name: String,
        latitude: Double,
        longitude: Double,
        notes: String
    )

    suspend fun isDataInserted(): Boolean
    suspend fun setDataInserted()
}