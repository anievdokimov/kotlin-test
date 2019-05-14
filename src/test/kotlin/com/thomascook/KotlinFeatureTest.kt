package com.thomascook

import com.thomascook.dao.verify
import com.thomascook.helpers.TestList
import io.kotlintest.specs.FeatureSpec

class KotlinFeatureTest : FeatureSpec({
    val testData = listOf(TestData.forHotel(), TestData.forPackage())
    val apiClient = ExpediaApiClient.default()

    feature("Expedia is able to POST a live booking EVENT") {
        testData.forEach { data ->
            scenario("post a live event to BHO for ${data.bookingType}") {
                val bookingRs = apiClient.postLiveEvent(body = data.payload)
                bookingRs?.verify(data.bookingType)
            }
        }
    }
})