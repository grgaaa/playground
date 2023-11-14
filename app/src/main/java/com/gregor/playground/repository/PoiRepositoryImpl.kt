package com.gregor.playground.repository

import com.gregor.playground.exceptions.RepositoryException
import com.gregor.playground.model.Poi
import com.gregor.playground.repository.dto.RepoDTO
import com.gregor.playground.repository.dto.Source
import com.gregor.playground.service.NetworkService
import javax.inject.Inject

class PoiRepositoryImpl @Inject constructor(
    private val networkService: NetworkService
) : PoiRepository {

    override fun getAll(): RepoDTO<List<Poi>> {
        val poisList = networkService.getPois().execute()

        return if (poisList.isSuccessful) {
            RepoDTO(poisList.body(), source = Source.REMOTE_SERVICE)
        } else {
            RepoDTO(null,
                true,
                RepositoryException(RepositoryException.NETWORK_ERROR),
                source = Source.REMOTE_SERVICE)
        }
    }
}