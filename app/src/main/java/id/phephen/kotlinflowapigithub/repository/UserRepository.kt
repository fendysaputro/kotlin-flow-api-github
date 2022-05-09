package id.phephen.kotlinflowapigithub.repository

import id.phephen.kotlinflowapigithub.model.UserModel
import id.phephen.kotlinflowapigithub.network.ApiService
import id.phephen.kotlinflowapigithub.network.UserApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by Phephen on 09/05/2022.
 */
class UserRepository (private val apiService: ApiService){

    suspend fun getUsers(query: String): Flow<UserApiState<UserModel>> {
        return flow {
            val user = apiService.getUsers(query)
            emit(UserApiState.success(user))
        }.flowOn(Dispatchers.IO)
    }

}