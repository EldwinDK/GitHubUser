package id.co.training.githubuser.ui.main.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.co.training.githubuser.ui.main.api.RetrofitClient
import id.co.training.githubuser.ui.main.data.model.DetailUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel:ViewModel() {
    val user = MutableLiveData<DetailUserResponse>()
    fun setUserDetail(username:String){
        RetrofitClient.apiInstance
            .getUserDetail(username)
            .enqueue(object : Callback<DetailUserResponse>{
                override fun onResponse(
                    call: Call<DetailUserResponse>,
                    response: Response<DetailUserResponse>
                ) {
                    if(response.isSuccessful)
                        user.postValue(response.body())
                }

                override fun onFailure(call: Call<DetailUserResponse>, t: Throwable) {
                    t.message?.let { Log.d("Failure", it) }
                }

            })
    }
    fun getUserDetail(): LiveData<DetailUserResponse>{
        return user
    }
}