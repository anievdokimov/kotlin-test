package com.thomascook.dao

import com.thomascook.dao.BookingEventType.CREATE
import com.thomascook.dao.BookingProductType.PACKAGE
import java.util.*

data class BookingRq(
    val DateTime: String = "2018-07-21T02:05:00",
    val EventType: BookingEventType = CREATE,
    val ItineraryNumber: String = hotelItineraryNumbers.random(),
    val ProductType: BookingProductType = BookingProductType.HOTEL,
    val PartnerConfirmationNumber: String = UUID.randomUUID().toString()

) {
    companion object {
        fun hotelBooking(): BookingRq = BookingRq()
        fun packageBooking(): BookingRq =
            BookingRq(ItineraryNumber = packageItineraryNumbers.random(), ProductType = PACKAGE)
    }
}




