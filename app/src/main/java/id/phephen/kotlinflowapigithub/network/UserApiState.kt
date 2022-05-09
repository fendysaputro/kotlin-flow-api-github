package id.phephen.kotlinflowapigithub.network

/**
 * Created by Phephen on 09/05/2022.
 */

data class UserApiState<out T>(val status: Status, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): UserApiState<T> {
            return UserApiState(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String): UserApiState<T> {
            return UserApiState(Status.ERROR, null, msg)
        }

        fun <T> loading(): UserApiState<T> {
            return UserApiState(Status.LOADING, null, null)
        }
    }

}

enum class Status {
    SUCCESS, ERROR, LOADING
}