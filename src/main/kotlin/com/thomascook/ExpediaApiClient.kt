package com.thomascook

import com.thomascook.dao.BookingRq
import com.thomascook.dao.BookingRs

class ExpediaApiClient(private val expediaAPIURL: String) {

    fun postLiveEvent(channel: String = "be", market: String = "b2c", body: BookingRq): BookingRs? {
        return BookingRs(
            DateTime = body.DateTime,
            EventType = body.EventType.name,
            ItineraryNumber = body.ItineraryNumber,
            PartnerConfirmationNumber = body.PartnerConfirmationNumber,
            Status = "SUCCESS"
        )
    }

    companion object {
        private const val path: String = "/booking-handoff-api/booking/%s/%s"
        fun default(): ExpediaApiClient {
            return ExpediaApiClient("http://booking-handoff-expedia-api-1-integration.thomascook.io:8081")
        }
    }
}

fun main() {
    ExpediaApiClient.default()
        .postLiveEvent(body = BookingRq.hotelBooking())

    print("%s/%s".format("1", "2"))
}