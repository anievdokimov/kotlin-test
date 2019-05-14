package com.thomascook

import com.thomascook.dao.verify
import io.kotlintest.TestCase
import io.kotlintest.specs.BehaviorSpec

class BehaviorTest : BehaviorSpec() {

    private val testData = listOf(TestData.forHotel(), TestData.forPackage())
    private lateinit var apiClient: ExpediaApiClient

    @Override
    override fun beforeTest(testCase: TestCase) {
        apiClient = ExpediaApiClient.default()
    }

    init {
        given("An Expedia wants to POST a Live Event")
        {
            testData.forEach { data ->
                `when`("Expedia sends a Live Event for ${data.bookingType}") {
                    val bookingRs = apiClient.postLiveEvent(body = data.payload)
                    then("I should be able to fly") {
                        bookingRs?.verify(data.bookingType)
                    }
                }
            }
        }

    }
}
