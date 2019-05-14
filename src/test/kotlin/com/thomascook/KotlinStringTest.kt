package com.thomascook

import com.thomascook.dao.verify
import com.thomascook.helpers.TestList
import io.kotlintest.IsolationMode
import io.kotlintest.extensions.TestListener
import io.kotlintest.specs.StringSpec
import io.kotlintest.tables.forAll
import io.kotlintest.tables.headers
import io.kotlintest.tables.row
import io.kotlintest.tables.table

class KotlinStringTest : StringSpec({


    "Request to Expedia API should be successfully processed" {
        val apiClient = ExpediaApiClient.default()
        table(
            headers("bookingPayload"),
            row(TestData.forHotel()),
            row(TestData.forPackage())
        ).forAll { testData ->
            /*
            * powerful matchers
            * https://github.com/kotlintest/kotlintest/blob/master/doc/matchers.md
            *
            * */
            apiClient.postLiveEvent(body = testData.payload)
                ?.verify(testData.bookingType)
        }

    }

}) {
    override fun isolationMode(): IsolationMode = IsolationMode.InstancePerTest
    override fun listeners(): List<TestListener> = listOf(DBListener)
}
