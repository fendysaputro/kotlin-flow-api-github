package id.phephen.kotlinflowapigithub.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.phephen.kotlinflowapigithub.model.UserModel
import id.phephen.kotlinflowapigithub.network.Status
import id.phephen.kotlinflowapigithub.network.UserApiState
import id.phephen.kotlinflowapigithub.repository.UserRepository
import id.phephen.kotlinflowapigithub.utils.Utils
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by Phephen on 09/05/2022.
 */
class UserViewModel : ViewModel() {

    private val repository = UserRepository (
        Utils.apiService()
    )

    val userState = MutableStateFlow(
        UserApiState(
            Status.LOADING, UserModel(), ""
        )
    )

    init {
        getUser("")
    }

    fun getUser(query: String) {
        userState.value = UserApiState.loading()

        viewModelScope.launch {
            repository.getUsers(query)
                .catch {
                    userState.value = UserApiState.error(it.message.toString())
                }
                .collect {
                    userState.value = UserApiState.success(it.data)
                }
        }

    }

}