package me.tabacowang.retrofitdaggerdemo.data

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.tabacowang.retrofitdaggerdemo.RepoAdapter
import javax.inject.Inject

class GithubRepository
@Inject constructor(private val service: GithubService) {
    fun getRepos(queryString: String, sort: String, page: Int, repoAdapter: RepoAdapter) =
            service.getRepos(queryString, sort, page)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .subscribe({
                        repoAdapter.repos = it.items
                    },{
                        it.printStackTrace()
                    })
}