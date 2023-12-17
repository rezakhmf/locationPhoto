package com.farahaniconsulting.locationphoto.data.model.dto.location

import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

data class Location(
    val id: Long,
    val name: String,
    @SerializedName("lat")
    val latitude: Double,
    @SerializedName("lng")
    val longitude: Double,
    var notes: String = ""
)

data class LocationsData(
    val locations: List<Location>,
    val updated: String
)

fun provideLocationData() = parseJsonToLocationsData(jsonLocationData)
private fun parseJsonToLocationsData(jsonData: String): LocationsData {
    val gson = Gson()
    val result = gson.fromJson(jsonData, LocationsData::class.java)
    result.locations.map { location ->
            location.notes = ""
    }
    return result
}

private const val jsonLocationData = """
        {
            "locations": [
                {
                    "name": "Milsons Point",
                    "lat": -33.850750,
                    "lng": 151.212519
                },
                {
                    "name": "Bondi Beach",
                    "lat": -33.889967,
                    "lng": 151.276440
                },
                {
                    "name": "Circular Quay",
                    "lat": -33.860178,
                    "lng": 151.212706
                },
                {
                    "name": "Manly Beach",
                    "lat": -33.797151,
                    "lng": 151.288784
                },
                {
                    "name": "Darling Harbour",
                    "lat": -33.873379,
                    "lng": 151.200940
                }
            ],
            "updated": "2016-12-01T06:52:08Z"
        }
    """

