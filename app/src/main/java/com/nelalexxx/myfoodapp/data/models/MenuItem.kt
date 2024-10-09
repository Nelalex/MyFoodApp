package com.nelalexxx.myfoodapp.data.models

data class MenuItem (
    val sourceId: Int,
    val descriptionText: String,
    val price: Int,
    var count: Int = 1
)