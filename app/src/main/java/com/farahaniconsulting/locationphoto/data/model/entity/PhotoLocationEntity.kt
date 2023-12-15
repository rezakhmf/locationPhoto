package com.farahaniconsulting.locationphoto.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos_locations")
data class PhotoLocationEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    var notes: String = ""
)