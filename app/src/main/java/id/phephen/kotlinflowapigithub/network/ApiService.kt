package id.phephen.kotlinflowapigithub.network

import id.phephen.kotlinflowapigithub.model.UserModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Phephen on 09/05/2022.
 */
interface ApiService {
    @GET("search/users/")
    suspend fun getUsers(@Query("q") q: String): UserModel
}