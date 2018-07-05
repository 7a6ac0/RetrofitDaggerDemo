package me.tabacowang.retrofitdaggerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import me.tabacowang.retrofitdaggerdemo.data.RepoResponse

class RepoAdapter(repos: List<RepoResponse.Repo>) : BaseAdapter() {
    var repos: List<RepoResponse.Repo> = repos
        set(repos) {
            field = repos
            notifyDataSetChanged()
        }

    override fun getView(i: Int, view: View?, viewGroup: ViewGroup): View {
        val repo = getItem(i)

        val rowView = view ?: LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.repo_item, viewGroup, false)

        with(rowView.findViewById<TextView>(R.id.repo_fullname)) {
            text = repo.fullName
        }

        return rowView
    }

    override fun getItem(i: Int) = repos[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getCount() = repos.size
}