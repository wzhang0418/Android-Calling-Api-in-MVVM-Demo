package com.apolis.wenzhao.interviewmock.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.apolis.wenzhao.interviewmock.api.EndPoint
import com.apolis.wenzhao.interviewmock.model.EpisodeData
import com.apolis.wenzhao.interviewmock.model.EpisodeResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository(private val endPoint: EndPoint) {

    val listEpisode: MutableLiveData<List<EpisodeData>> by lazy {
        MutableLiveData<List<EpisodeData>>()
    }

    //This method is used to get Episode data from API
    fun getEpisodeRepo() {
        endPoint.getEpisode().enqueue(object : Callback<EpisodeResponse> {
            override fun onFailure(call: Call<EpisodeResponse>, t: Throwable) {
                Log.d("MYTAG", "get data failure")
                Log.d("MYTAG", t.message.toString())
            }
            override fun onResponse(call: Call<EpisodeResponse>, response: Response<EpisodeResponse>) {
                val episodeResponse = response.body()
                listEpisode.postValue(episodeResponse?.episodeData)
                Log.d("MYTAG", "get data response")
            }
        })
    }
}