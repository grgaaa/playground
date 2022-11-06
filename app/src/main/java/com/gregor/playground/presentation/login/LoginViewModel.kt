package com.gregor.playground.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.gregor.playground.model.User
import com.gregor.playground.repository.UserAccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userAccountRepository: UserAccountRepository
    ) : ViewModel() {


    fun login(userName:String, password:String) : LiveData<User> {
        val loginSingle = userAccountRepository.login(userName, password)
            .onErrorReturnItem(User("", ""))
            .toFlowable()

        return LiveDataReactiveStreams.fromPublisher(loginSingle)
    }

    override fun onCleared() {
        super.onCleared()
    }
}