package com.farahaniconsulting.locationphoto.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.farahaniconsulting.locationphoto.data.model.entity.ControlEntity

@Dao
interface ControlDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertControl(controlEntity: ControlEntity)

    @Query("SELECT * FROM control_table WHERE id = 1")
    suspend fun getControl(): ControlEntity?
}