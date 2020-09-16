package com.apolis.wenzhao.interviewmock.viewmodel

import androidx.lifecycle.ViewModel
import com.apolis.wenzhao.interviewmock.api.ApiClient
import com.apolis.wenzhao.interviewmock.repository.EpisodeRepository

class EpisodeViewModel : ViewModel() { //Business logic

    private val episodeRepository = EpisodeRepository(ApiClient.getApiEndPoint())

    fun getEpisodeObserver() = episodeRepository.listEpisode

    fun getEpisodeData() = episodeRepository.getEpisodeRepo()

}