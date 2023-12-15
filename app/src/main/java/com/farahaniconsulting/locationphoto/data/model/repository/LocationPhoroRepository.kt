package com.farahaniconsulting.locationphoto.data.model.repository

import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.dto.location.provideLocationData
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity
import javax.inject.Inject


interface LocationPhotoRepository {
    suspend fun getDefaultLocations(): List<Location>?
    suspend fun getAllLocations(): List<PhotoLocationEntity>
    suspend fun saveCustomLocation(
        name: String,
        latitude: Double,
        longitude: Double
    )
    suspend fun updateLocation(
        id: Long,
        name: String,
        latitude: Double,
        longitude: Double
    )
}

class LocationPhotoRepositoryImp @Inject constructor(
    private val photoLocationDao: PhotoLocationDao
) : LocationPhotoRepository {
    override suspend fun getDefaultLocations() = provideLocationData().locations

    override suspend fun getAllLocations(): List<PhotoLocationEntity> {
        return photoLocationDao.getAllPhotoLocations()
    }

    override suspend fun saveCustomLocation(
        name: String,
        latitude: Double,
        longitude: Double
    ) {
        val customLocation = PhotoLocationEntity(
            name = name,
            latitude = latitude,
            longitude = longitude
        )
        photoLocationDao.insertPhotoLocation(customLocation)
    }

    override suspend fun updateLocation(
        id: Long,
        name: String,
        latitude: Double,
        longitude: Double
    ) {
        val customLocation = PhotoLocationEntity(
            id = id,
            name = name,
            latitude = latitude,
            longitude = longitude
        )
        photoLocationDao.updatePhotoLocation(customLocation)
    }
}