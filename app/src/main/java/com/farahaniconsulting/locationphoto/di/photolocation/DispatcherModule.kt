package com.farahaniconsulting.locationphoto.di.photolocation

import com.farahaniconsulting.locationphoto.dispatcher.AppDispatcher
import com.farahaniconsulting.locationphoto.dispatcher.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Singleton
    @Provides
    fun provideDispatcherProvider(): DispatcherProvider
            = AppDispatcher()
}