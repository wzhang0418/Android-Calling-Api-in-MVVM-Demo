package com.apolis.wenzhao.interviewmock.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class EpisodeResponse(
    val info: Info,
    @SerializedName("results")
    val episodeData: List<EpisodeData>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
): Serializable

data class EpisodeData(
    val air_date: String? = null,
    val characters: List<String>? = null,
    val created: String? = null,
    val episode: String? = null,
    val id: String? = null,
    val name: String? = null,
    val url: String? = null
): Serializable