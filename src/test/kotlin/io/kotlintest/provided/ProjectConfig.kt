package io.kotlintest.provided

import com.thomascook.getLogger
import io.kotlintest.AbstractProjectConfig

object ProjectConfig : AbstractProjectConfig() {
    private val logger = getLogger(ProjectConfig.javaClass)


    override fun beforeAll() {
        logger.info("Global Setup before Test Suit")
    }

    override fun afterAll() {
        logger.info("Global Cleanup after Test Suit")
    }

}
