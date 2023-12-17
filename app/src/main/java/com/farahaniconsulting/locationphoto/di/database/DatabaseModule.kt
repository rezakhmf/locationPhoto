package com.farahaniconsulting.locationphoto.di.database

import android.content.Context
import androidx.room.Room
import com.farahaniconsulting.locationphoto.data.local.dao.ControlDao
import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Singleton
    @Provides
    fun providePhotoLocationDao(database: AppDatabase): PhotoLocationDao {
        return database.photoLocationDao()
    }

    @Singleton
    @Provides
    fun provideControlDao(database: AppDatabase): ControlDao {
        return database.controlDao()
    }
}