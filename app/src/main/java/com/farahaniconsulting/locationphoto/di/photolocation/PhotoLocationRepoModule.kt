package com.farahaniconsulting.locationphoto.di.photolocation

import com.farahaniconsulting.locationphoto.data.local.dao.ControlDao
import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepository
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepositoryImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PhotoLocationRepoModule {

    @Provides
    fun providePhotoLocationRepository(
    photoLocationDao: PhotoLocationDao,
    controlDao: ControlDao
    ) : LocationPhotoRepository {
     return  LocationPhotoRepositoryImp(
         photoLocationDao,
         controlDao)
    }
}