package jp.co.yumemi.android.code_check.domain.core

/**
 * Executes business logic
 */
interface UseCase<in Arguments, out ReturnType> {
    suspend fun execute(arguments: Arguments): ReturnType
}
