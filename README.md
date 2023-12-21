# Photo Location Project

I am Reza Farahani

# Project Title

Photo Locations Map

<img src = "https://github.com/rezakhmf/locationPhoto/assets/3985692/5b3dc333-5090-45ec-b8a3-e181ccafaefc" width="200" height="400" />




## Getting Started

This project stack is 

* MVVM and Clean - Architecture
* Hilt (https://dagger.dev/hilt/) - Dependency Management
* Android JetckPack (https://developer.android.com/jetpack) -
  * Compose
  * ViewModel
  * Room Database
  * Google Map SDK
* [Kotlin](https://kotlinlang.org/) - Statically typed programming language(coroutine, flow)
* [Coroutine](https://kotlinlang.org/docs/reference/coroutines-overview.html) - A library for composing asynchronous and event-based programs

### Features
 
Imagine you are briefed with writing an app for a social photography startup. They maintain a list of
scenic photo locations around Sydney. Their users would like to see all these default locations, plus
be able to add their own locations, as well as add notes about each location.
The app needs to import these default locations from a JSON file that you are provided with. User added
locations only need to be persisted locally. A user should be able to see all locations on a
map, as well as in a list. A user should be able to input and edit notes as text for any location. You
will need to make assumptions about how users will interact with the app. Please write down all your
assumptions clearly.

#### Product requirements
* Provide a map screen (using any map SDK of your choosing)
* Allow custom locations to be added from the map screen
* The user should be able to provide names for these locations
* Show pins for both default and custom locations on the map
* Provide a screen listing all locations, sorted by distance
* When locations are selected on either the map or list screen, show a detail screen
* In the detail screen, allow the user to enter notes about the location
* All information entered by the user must be persisted between app launches

### Not Included
 * Accepting wrong lat/long
 * Sort by Distance
 * Add Location based on the Map
   
### Installing

* It just needs to import to Android Studio Dolphin | 2021.3.1
* necessary comments are added

### Tests Covered

* LocationPhotoUseCaseTests
* LocationPhotoRepositoryTests


## Authors

* **[Reza Farahani](https://www.linkedin.com/in/reza-farahani-7a7bb74b)** - 

## Acknowledgments
Kotlin
