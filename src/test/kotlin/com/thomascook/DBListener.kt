package com.thomascook

import io.kotlintest.Spec
import io.kotlintest.TestCase
import io.kotlintest.TestResult
import io.kotlintest.extensions.TestListener
import io.kotlintest.provided.ProjectConfig

object DBListener : TestListener {
    private val logger = getLogger(ProjectConfig.javaClass)

    override fun beforeTest(testCase: TestCase) {
        //common setup before each test
        logger.info("Test started ${testCase.name}")
    }

    override fun beforeSpec(spec: Spec) {
        logger.info("Spec started $spec")
    }

    override fun afterTest(testCase: TestCase, result: TestResult) {
        //common cleanup after each test
        logger.info("Test finished ${testCase.name}, result - ${result.status}")
    }

}