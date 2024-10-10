package com.nelalexxx.myfoodapp.data.models

data class MenuItem (
    val sourceId: Int, // R.drawable
    val descriptionText: String, // Just simple text
    val price: Int, // Simple price
    var count: Int = 1 // To display amount of equal items
)