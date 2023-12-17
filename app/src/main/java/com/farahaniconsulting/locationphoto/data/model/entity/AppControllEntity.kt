package com.farahaniconsulting.locationphoto.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "control_table")
data class ControlEntity(
    @PrimaryKey
    val id: Int = 1,
    val dataInserted: Boolean,
    val date: Long
)
