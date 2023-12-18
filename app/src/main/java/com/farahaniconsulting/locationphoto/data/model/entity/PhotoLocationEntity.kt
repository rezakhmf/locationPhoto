package com.farahaniconsulting.locationphoto.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location

@Entity(tableName = "photos_locations")
data class PhotoLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    var notes: String = ""
)

fun List<PhotoLocationEntity>.asDomainModel(): List<Location> {
    return map {
        Location (
            id = it.id,
            name = it.name,
            latitude = it.latitude,
            longitude = it.longitude,
             notes = it.notes
        )
    }
}