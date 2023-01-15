package com.gregor.playground.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gregor.playground.model.User
import com.gregor.playground.repository.UserAccountRepositoryImpl
import com.gregor.playground.repository.dto.RepoDTO
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userAccountRepository: UserAccountRepositoryImpl
) : ViewModel() {

    private val loginLiveData: MutableLiveData<RepoDTO<User>> = MutableLiveData()

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun login(userName: String, password: String): LiveData<RepoDTO<User>> {
        val loginSingle = Observable.fromSingle {
            val user = userAccountRepository.login(userName, password)
            it.onSuccess(user)
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { user ->
                    loginLiveData.postValue(user)
                },
                { throwable ->
                    loginLiveData.postValue(RepoDTO(null, true, throwable))
                }
            )
        disposables.add(loginSingle)
        return loginLiveData
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}