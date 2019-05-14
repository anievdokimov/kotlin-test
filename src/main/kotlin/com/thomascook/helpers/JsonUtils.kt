package com.thomascook.helpers

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule


object JsonUtils {
    private val objectMapper: ObjectMapper = ObjectMapper()
        .registerKotlinModule()


    fun asJsonString(content: Any): String {
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true)
        val jsonNode = objectMapper.valueToTree<JsonNode>(content)
        return objectMapper.writeValueAsString(jsonNode)
    }
}
