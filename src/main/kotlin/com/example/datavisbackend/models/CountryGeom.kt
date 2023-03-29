package com.example.datavisbackend.models


import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.locationtech.jts.geom.MultiPolygon


@Entity
@Table(name = "country_geometry_merc", schema="countries")
data class CountryGeom(
    @Id @Column(name = "gid")
    val gid: Int,
    @Column(name = "country")
    val countryName: String,
    @Column(name = "iso_code")
    val isoCode: String,
    @Column(name = "geometry", columnDefinition = "geometry(MultiPolygon)")
    val geom: MultiPolygon
)
