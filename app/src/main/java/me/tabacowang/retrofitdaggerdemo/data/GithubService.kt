package me.tabacowang.retrofitdaggerdemo.data

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubService
@Inject constructor(retrofit: Retrofit) : GithubApi {
    private val githubApi by lazy { retrofit.create(GithubApi::class.java) }
    override fun getRepos(queryString: String, sort: String, page: Int) = githubApi.getRepos(queryString, sort, page)
}