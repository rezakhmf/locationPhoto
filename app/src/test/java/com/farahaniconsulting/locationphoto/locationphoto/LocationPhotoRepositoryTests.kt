package com.farahaniconsulting.locationphoto.locationphoto

import com.farahaniconsulting.locationphoto.data.local.dao.ControlDao
import com.farahaniconsulting.locationphoto.data.local.dao.PhotoLocationDao
import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.dto.location.provideLocationData
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepository
import com.farahaniconsulting.locationphoto.data.model.repository.LocationPhotoRepositoryImp
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class LocationPhotoRepositoryTests {

    // Arrange
    private lateinit var mockPhotoDao: PhotoLocationDao
    private lateinit var mockControlDao: ControlDao

    private lateinit var locationRepository: LocationPhotoRepositoryImp
    private lateinit var repository: LocationPhotoRepositoryImp

    @Before
    fun setUp() {
        mockPhotoDao = mockk<PhotoLocationDao>()
        mockControlDao = mockk<ControlDao>()
        repository = LocationPhotoRepositoryImp(mockPhotoDao, mockControlDao)
    }

    @Test
    fun `test get all locations`() {
        // Mock the behavior
        coEvery { repository.getAllLocations() } returns locationEntityProvider()

        //Act
        val result = runBlocking {
            repository.getAllLocations()
        }

        assertEquals(result, locationEntityProvider())
    }

    @Test
    fun `test save locations`() {
        // Mock repository response
        val location = Location(1, "Custom Location", 12.345, 67.890)

        coEvery { repository.saveCustomLocation(
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude,
            notes = location.notes
        ) } returns Unit

        //Act
        val result = runBlocking {
            repository.saveCustomLocation(
                name = location.name,
                latitude = location.latitude,
                longitude = location.longitude,
                notes = location.notes)
        }

        // Assert
        assertEquals(result, Unit)
    }

    @Test
    fun `test update location`() {
        // Mock repository response
        val location = Location(1, "Custom Location", 12.345, 67.890)

        coEvery { repository.updateLocation(
            id = location.id,
            name = location.name,
            latitude = location.latitude,
            longitude = location.longitude,
            notes = location.notes
        ) } returns Unit

        //Act
        val result = runBlocking {
            repository.updateLocation(
                id = location.id,
                name = location.name,
                latitude = location.latitude,
                longitude = location.longitude,
                notes = location.notes)
        }

        // Assert
        assertEquals(result, Unit)
    }
}