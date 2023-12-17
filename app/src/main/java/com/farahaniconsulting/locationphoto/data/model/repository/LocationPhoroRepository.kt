package com.farahaniconsulting.locationphoto.data.model.repository

import com.farahaniconsulting.locationphoto.data.local.dao.ControlDao
import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.dto.location.provideLocationData
import com.farahaniconsulting.locationphoto.data.model.entity.ControlEntity
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity
import javax.inject.Inject


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

class LocationPhotoRepositoryImp @Inject constructor(
    private val photoLocationDao: PhotoLocationDao,
    private val controlDao: ControlDao
) : LocationPhotoRepository {
    override suspend fun getDefaultLocations() = provideLocationData().locations

    override suspend fun getAllLocations(): List<PhotoLocationEntity> {
        if (!isDataInserted()) {
            provideLocationData().locations.forEach { location ->
                photoLocationDao.insertPhotoLocation(
                    PhotoLocationEntity(
                        id = location.id,
                        name = location.name,
                        latitude = location.latitude,
                        longitude = location.longitude,
                        notes = location.notes
                    )
                )
            }
            setDataInserted()
        }
        return photoLocationDao.getAllPhotoLocations()
    }

    override suspend fun saveCustomLocation(
        name: String,
        latitude: Double,
        longitude: Double,
        notes: String
    ) {
        val customLocation = PhotoLocationEntity(
            name = name,
            latitude = latitude,
            longitude = longitude,
            notes = notes
        )
        photoLocationDao.insertPhotoLocation(customLocation)
    }

    override suspend fun updateLocation(
        id: Long,
        name: String,
        latitude: Double,
        longitude: Double,
        notes: String
    ) {
        val customLocation = PhotoLocationEntity(
            id = id,
            name = name,
            latitude = latitude,
            longitude = longitude,
            notes = notes
        )

        photoLocationDao.updatePhotoLocation(customLocation)
    }

    override suspend fun isDataInserted() =
        controlDao.getControl() != null

    override suspend fun setDataInserted() {
        controlDao.insertControl(
            ControlEntity(
                dataInserted = true,
                date = System.currentTimeMillis()
            )
        )
    }
}