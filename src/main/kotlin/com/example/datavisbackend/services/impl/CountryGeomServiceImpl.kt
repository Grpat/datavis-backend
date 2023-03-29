package com.example.datavisbackend.services.impl


import com.example.datavisbackend.models.CountryGeom
import com.example.datavisbackend.repository.CountryGeomRepository
import com.example.datavisbackend.services.CountryGeomService
import org.locationtech.jts.geom.Geometry
import org.springframework.stereotype.Service
import org.wololo.geojson.Feature
import org.wololo.geojson.FeatureCollection
import org.wololo.jts2geojson.GeoJSONWriter


@Service
class CountryGeomServiceImpl(
    private val countryGeomRepository: CountryGeomRepository,
    private val geoJsonWriter: GeoJSONWriter
) : CountryGeomService {

    override fun getAllCountryBoundaries(): FeatureCollection {
        val countryBoundaries = countryGeomRepository.findAll()
        val features = countryBoundaries
            .filter { it.geom != null }
            .map { countryBoundary -> createFeature(countryBoundary) }

        return FeatureCollection(features.toTypedArray())
    }

    private fun createFeature(countryGeom: CountryGeom): Feature {
        val centroid = getCentroid(countryGeom.geom)
        val properties = mapOf(
            "gid" to countryGeom.gid,
            "country" to countryGeom.countryName,
            "isoCode" to countryGeom.isoCode,
            "centroid" to listOf(centroid.coordinate.x, centroid.coordinate.y)
        )
        return Feature(writeGeoJson(countryGeom.geom), properties)
    }

    private fun getCentroid(geometry: Geometry): Geometry {
        return geometry.centroid
    }

    private fun writeGeoJson(geometry: Geometry): org.wololo.geojson.Geometry
    {
        return geoJsonWriter.write(geometry)
    }
}
