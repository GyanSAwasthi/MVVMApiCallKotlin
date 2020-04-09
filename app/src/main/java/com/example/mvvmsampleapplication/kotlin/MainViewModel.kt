package com.example.mvvmsampleapplication.kotlin

import android.provider.ContactsContract
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleapplication.java.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    //var userLiveData: MutableLiveData<ArrayList<User>> = MutableLiveData()
    var userLiveData: MutableLiveData<ArrayList<DataModel>> = MutableLiveData()

    var dataList = ArrayList<DataModel>()

    lateinit var userArrayList: ArrayList<User>

    init {

        getData()
        init()
    }

    fun getResults(): MutableLiveData<ArrayList<DataModel>> {
        return userLiveData

    }

    private fun init() {
        populateList()
        //userLiveData.setValue(userArrayList);
    }

    private fun populateList() {
//       var user: User = User("Darknight","Best rating movie")
        var user: User = User()

        user.title = "Darknight"
        user.description = "Best rating movie"

        userArrayList = arrayListOf()
        userArrayList.add(user)
        userArrayList.add(user)
        userArrayList.add(user)
        userArrayList.add(user)
        userArrayList.add(user)
        userArrayList.add(user)


    }

    private fun getData() {
        val call: Call<List<DataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataModel>> {

            override fun onResponse(call: Call<List<DataModel>>?, response: Response<List<DataModel>>?) {
                // progerssProgressDialog.dismiss()
                dataList.addAll(response!!.body()!!)
                userLiveData.setValue(dataList);

                Log.v("API DATA",response.body().toString())
            }

            override fun onFailure(call: Call<List<DataModel>>?, t: Throwable?) {
            }

        })

    }
}