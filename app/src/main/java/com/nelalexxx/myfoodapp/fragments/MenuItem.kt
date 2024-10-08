package com.nelalexxx.myfoodapp.fragments

data class MenuItem (
    val sourceId: Int,
    val descriptionText: String,
    val price: Int,
    var count: Int = 1
) {

    class Base {

    }

}