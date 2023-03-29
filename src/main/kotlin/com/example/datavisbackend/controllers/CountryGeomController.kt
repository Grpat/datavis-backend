package com.example.datavisbackend.controllers

import com.example.datavisbackend.services.CountryGeomService
import org.springframework.web.bind.annotation.CrossOrigin


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.wololo.geojson.FeatureCollection

@RestController
@RequestMapping("/v1/countryBoundaries")
class CountryGeomController(private val countryGeomService: CountryGeomService) {
    @GetMapping
    fun getAllCountryBoundaries():FeatureCollection{
        return  countryGeomService.getAllCountryBoundaries()
    }
}