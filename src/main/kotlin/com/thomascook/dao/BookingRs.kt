package com.thomascook.dao

import io.kotlintest.matchers.collections.shouldBeOneOf
import io.kotlintest.matchers.types.shouldBeTypeOf
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe

data class BookingRs(
    val DateTime: String,
    val EventType: String,
    val ItineraryNumber: String,
    val Status: String,
    val PartnerConfirmationNumber: String
)

fun BookingRs.verify(bookingType: BookingProductType) {
    this.shouldNotBeNull()
    this.EventType.shouldBeOneOf(BookingEventType.values().map { it.name })
    this.Status.shouldBe("SUCCESS")
    this.Status.shouldBeTypeOf<String> { it.javaClass }
    val expectedHotelNumbers = if (bookingType == BookingProductType.HOTEL) {
        hotelItineraryNumbers
    } else {
        packageItineraryNumbers
    }
    this.ItineraryNumber.shouldBeOneOf(expectedHotelNumbers)
}