package jp.co.yumemi.android.code_check.domain.repositories

import jp.co.yumemi.android.code_check.domain.entities.GithubRepo

interface SearchRepository {
    fun searchRepos(searchText: String): List<GithubRepo>
}
