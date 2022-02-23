/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.code_check

import android.content.Context
import androidx.lifecycle.ViewModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.util.*
import jp.co.yumemi.android.code_check.TopActivity.Companion.lastSearchDate
import jp.co.yumemi.android.code_check.domain.entities.GithubRepo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.json.JSONObject

/**
 * TwoFragment で使う
 */
class OneViewModel(
    val context: Context
) : ViewModel() {

    // 検索結果
    fun searchResults(inputText: String): List<GithubRepo> = runBlocking {
        val client = HttpClient(Android)

        return@runBlocking GlobalScope.async {
            val response: HttpResponse = client?.get("https://api.github.com/search/repositories") {
                header("Accept", "application/vnd.github.v3+json")
                parameter("q", inputText)
            }

            val jsonBody = JSONObject(response.receive<String>())

            val jsonItems = jsonBody.optJSONArray("items")!!

            val items = mutableListOf<GithubRepo>()

            /**
             * アイテムの個数分ループする
             */
            for (i in 0 until jsonItems.length()) {
                val jsonItem = jsonItems.optJSONObject(i)!!
                val name = jsonItem.optString("full_name")
                val ownerIconUrl = jsonItem.optJSONObject("owner")!!.optString("avatar_url")
                val language = jsonItem.optString("language")
                val stargazersCount = jsonItem.optLong("stargazers_count")
                val watchersCount = jsonItem.optLong("watchers_count")
                val forksCount = jsonItem.optLong("forks_conut")
                val openIssuesCount = jsonItem.optLong("open_issues_count")

                items.add(
                    GithubRepo(
                        name = name,
                        ownerIconUrl = ownerIconUrl,
                        language = context.getString(R.string.written_language, language),
                        stargazersCount = stargazersCount.toInt(),
                        watchersCount = watchersCount.toInt(),
                        forksCount = forksCount.toInt(),
                        openIssuesCount = openIssuesCount.toInt()
                    )
                )
            }

            lastSearchDate = Date()

            return@async items.toList()
        }.await()
    }
}
