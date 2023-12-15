package com.farahaniconsulting.locationphoto.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity

@Dao
interface PhotoLocationDao {
    @Query("SELECT * FROM photos_locations")
    suspend fun getAllPhotoLocations(): List<PhotoLocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotoLocation(location: PhotoLocationEntity)

    @Update
    suspend fun updatePhotoLocation(location: PhotoLocationEntity)
}
