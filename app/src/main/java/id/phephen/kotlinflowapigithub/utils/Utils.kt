package id.phephen.kotlinflowapigithub.utils

import com.google.gson.GsonBuilder
import id.phephen.kotlinflowapigithub.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Phephen on 09/05/2022.
 */
object Utils {

    private const val BASE_URL = "https://api.github.com/"

    fun apiService(): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiService::class.java)

}