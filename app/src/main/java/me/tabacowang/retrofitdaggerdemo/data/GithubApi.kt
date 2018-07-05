package me.tabacowang.retrofitdaggerdemo.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

internal interface GithubApi {
    companion object {
        private const val SEARCH_REPOSITORIES = "search/repositories"
        private const val QUERY = "q"
        private const val SORT = "sort"
        private const val PAGE = "page"
    }

    @GET(SEARCH_REPOSITORIES)
    fun getRepos(@Query(QUERY) queryString: String,
                 @Query(SORT) sort: String = "stars",
                 @Query(PAGE) page: Int = 1): Observable<RepoResponse>
}