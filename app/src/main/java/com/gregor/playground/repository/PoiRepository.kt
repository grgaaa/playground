package com.gregor.playground.repository

import com.gregor.playground.model.Poi
import com.gregor.playground.repository.dto.RepoDTO

interface PoiRepository {

    fun getAll(): RepoDTO<List<Poi>>

}