package com.farahaniconsulting.locationphoto.ui.common

data class UIState<T>(
    val isLoading: Boolean = false,
    var data: T? = null,
    val error: String? = null
)