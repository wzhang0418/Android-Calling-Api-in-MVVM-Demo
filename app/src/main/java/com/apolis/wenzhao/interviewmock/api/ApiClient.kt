package com.apolis.wenzhao.interviewmock.api

import com.apolis.wenzhao.interviewmock.model.EpisodeResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiClient {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val endpoint: EndPoint by lazy {
        //retrofit client that is used to call the network call
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        client.create(EndPoint::class.java)
    }

    fun getApiEndPoint(): EndPoint = endpoint
}

interface EndPoint {
    @GET("episode")
    fun getEpisode(): Call<EpisodeResponse>
}