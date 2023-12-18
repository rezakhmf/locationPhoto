package com.farahaniconsulting.locationphoto.locationphoto

import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepository
import com.farahaniconsulting.locationphoto.domain.LocationPhotoUseCase
import com.farahaniconsulting.locationphoto.util.ResultData
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class LocationPhotoUseCaseTests {

    // Arrange
    private val mockRepository = mockk<LocationPhotoRepository>()
    private val useCase = LocationPhotoUseCase(mockRepository)

    @Before
    fun setUp() {}

    @Test
    fun `test get all locations`() {
        // Mock repository response
        coEvery { mockRepository.getAllLocations() } returns locationEntityProvider()

        // Act
        val result = runBlocking {
            useCase.getPhotoLocations()
        }

        // Assert
        assertEquals(ResultData.Success(photoLocationProvider()), result)
    }

    @Test
    fun `test save locations`() {
        // Mock repository response
        val location = Location(1, "Custom Location", 12.345, 67.890)

        coEvery { mockRepository.saveCustomLocation(
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude,
            notes = location.notes)
        } returns Unit

        // Act
        val result = runBlocking {
            useCase.saveLocation(location)
        }

        // Assert
        assertEquals(result, Unit)
    }
}