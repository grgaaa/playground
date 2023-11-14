package com.gregor.playground.presentation.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gregor.playground.model.Poi
import com.gregor.playground.repository.PoiRepository
import com.gregor.playground.repository.dto.RepoDTO
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

class MapViewModel @Inject constructor(
    private val poiRepository: PoiRepository
) : ViewModel() {

    private val mapLiveData: MutableLiveData<RepoDTO<Poi>> = MutableLiveData()

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun getPois(): LiveData<RepoDTO<Poi>> {
        return mapLiveData
    }

}