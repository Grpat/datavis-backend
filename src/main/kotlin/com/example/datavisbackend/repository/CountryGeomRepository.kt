package com.example.datavisbackend.repository

import com.example.datavisbackend.models.CountryGeom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryGeomRepository : JpaRepository<CountryGeom, Int>