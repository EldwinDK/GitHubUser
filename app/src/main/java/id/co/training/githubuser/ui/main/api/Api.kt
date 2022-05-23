package id.co.training.githubuser.ui.main.api

import id.co.training.githubuser.ui.main.data.model.DetailUserResponse
import id.co.training.githubuser.ui.main.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization:token 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")
    fun getSearchUsers(
        @Query("q") query:String
    ):Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization:token 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")
    fun getUserDetail(
        @Path("username") username:String
    ):Call<DetailUserResponse>
}