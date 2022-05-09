package id.phephen.kotlinflowapigithub.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Phephen on 09/05/2022.
 */
data class UserModel(
    @SerializedName("login")
    val login: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("node_id")
    val nodeId: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("gravatar_id")
    val gravatarId: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null
)
