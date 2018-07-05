package me.tabacowang.retrofitdaggerdemo.data

import com.google.gson.annotations.SerializedName

data class RepoResponse(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("incomplete_results")
        val incompleteResults: Boolean,
        val items: List<Repo>
){
        data class Repo(val id: String,
                        @SerializedName("name")
                        val name: String,
                        @SerializedName("full_name")
                        val fullName: String,
                        @SerializedName("description")
                        val description: String?,
                        @SerializedName("html_url")
                        val htmlUrl: String,
                        @SerializedName("stargazers_count")
                        val stars: Int)
}