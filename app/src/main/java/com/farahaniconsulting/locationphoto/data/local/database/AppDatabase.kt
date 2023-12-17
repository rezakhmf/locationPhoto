package com.farahaniconsulting.locationphoto.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.farahaniconsulting.locationphoto.data.local.dao.ControlDao
import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.model.entity.ControlEntity
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity

@Database(entities = [
    PhotoLocationEntity::class,
    ControlEntity::class],
    version = 1,
    exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photoLocationDao(): PhotoLocationDao
    abstract fun controlDao(): ControlDao
}