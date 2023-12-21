package com.farahaniconsulting.locationphoto.di.photolocation

import com.farahaniconsulting.locationphoto.data.local.dao.ControlDao
import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepositoryImp
import com.farahaniconsulting.locationphoto.domain.LocationPhotoRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface PhotoLocationRepoModule {
    @Binds
    fun providePhotoLocationRepositoryIn(
        locationPhotoRepositoryImp: LocationPhotoRepositoryImp
    ) : LocationPhotoRepository
}