package com.farahaniconsulting.locationphoto.locationphoto

import com.farahaniconsulting.locationphoto.data.model.dto.location.Location
import com.farahaniconsulting.locationphoto.data.model.entity.PhotoLocationEntity
import com.farahaniconsulting.locationphoto.data.model.entity.asDomainModel

fun photoLocationProvider(): List<Location> =
    locationEntityProvider().asDomainModel()

fun locationEntityProvider(): List<PhotoLocationEntity> {
    val locationOne = PhotoLocationEntity(
        id = 1,
        name = "Milsons Point",
        latitude = -33.850750,
        longitude = 151.212519
    )
    val locationTwo = PhotoLocationEntity(
        id = 1,
        name = "Bondi Beach",
        latitude = -33.850750,
        longitude = 151.212519
    )
    val locationThree = PhotoLocationEntity(
        id = 1,
        name = "Circular Quay",
        latitude = -33.850750,
        longitude = 151.212519
    )
    val locationFour = PhotoLocationEntity(
        id = 1,
        name = "Manly Beach",
        latitude = -33.850750,
        longitude = 151.212519
    )
    val locationFive = PhotoLocationEntity(
        id = 1,
        name = "Milsons Point",
        latitude = -33.850750,
        longitude = 151.212519
    )
    return listOf(locationOne, locationTwo, locationThree, locationFour, locationFive)
}