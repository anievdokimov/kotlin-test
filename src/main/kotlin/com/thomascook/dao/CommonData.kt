package com.thomascook.dao

enum class BookingProductType {
    HOTEL, PACKAGE
}

enum class BookingEventType {
    DONE, CANCEL, UPDATE, CREATE
}

val hotelItineraryNumbers = listOf("7352305818112", "7353007382134")
val packageItineraryNumbers = listOf("790144350142", "790144525705")