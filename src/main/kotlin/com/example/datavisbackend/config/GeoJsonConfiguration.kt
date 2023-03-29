package com.example.datavisbackend.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.wololo.jts2geojson.GeoJSONWriter


@Configuration
class GeoJsonConfiguration {
    @Bean
    fun geoJSONWriter(): GeoJSONWriter {
        return GeoJSONWriter()
    }
}