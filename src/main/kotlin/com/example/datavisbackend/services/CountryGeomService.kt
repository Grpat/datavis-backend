package com.example.datavisbackend.services
import org.wololo.geojson.FeatureCollection


interface CountryGeomService {
    fun getAllCountryBoundaries():FeatureCollection
}