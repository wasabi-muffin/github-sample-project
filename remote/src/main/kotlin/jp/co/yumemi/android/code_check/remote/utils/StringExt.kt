package jp.co.yumemi.android.code_check.remote.utils

fun String.filterRepoName(startPathDelimiter: String = "repos", endPathDelimiter: String) =
    substringAfter("https://api.github.com/$startPathDelimiter/").substringBefore("/$endPathDelimiter")
