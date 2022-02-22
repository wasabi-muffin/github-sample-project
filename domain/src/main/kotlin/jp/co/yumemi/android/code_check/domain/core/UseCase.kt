package jp.co.yumemi.android.code_check.domain.core

interface UseCase<in Arguments, out ReturnType> {
    suspend fun execute(arguments: Arguments): ReturnType
}
