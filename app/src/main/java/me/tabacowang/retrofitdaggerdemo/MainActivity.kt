package me.tabacowang.retrofitdaggerdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import me.tabacowang.retrofitdaggerdemo.data.GithubRepository
import me.tabacowang.retrofitdaggerdemo.di.AppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val repoAdapter by lazy { RepoAdapter(ArrayList(0)) }

    private val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as MainApplication).appComponent
    }

    @Inject lateinit var githubRepository: GithubRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<ListView>(R.id.repos_list).apply { adapter = repoAdapter }

        appComponent.inject(this)
        githubRepository.getRepos("topic:kotlin", "stars", 1, repoAdapter)
    }
}
