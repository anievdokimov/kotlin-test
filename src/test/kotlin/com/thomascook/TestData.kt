package com.thomascook

import com.thomascook.dao.BookingProductType
import com.thomascook.dao.BookingProductType.HOTEL
import com.thomascook.dao.BookingProductType.PACKAGE
import com.thomascook.dao.BookingRq


data class TestData(
    val bookingType: BookingProductType,
    val payload: BookingRq
) {
    companion object Builder {
        fun forHotel() = TestData(HOTEL, BookingRq.hotelBooking())
        fun forPackage() = TestData(PACKAGE, BookingRq.packageBooking())
    }
}
