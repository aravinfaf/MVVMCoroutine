package com.aravind.smb

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class SmbViewmodel : ViewModel() {

    var configresponse : MutableLiveData<FileListModel> = MutableLiveData()
    var mconfigresponse : LiveData<FileListModel> = configresponse

    fun getSmbJson(context: Context){
        var json : String = context.assets.open("smb.json").bufferedReader().use {
            it.readText()
        }
        Log.e("SSS",json)
        val gson = Gson()
        val data = gson.fromJson(json,FileListModel::class.java)
        configresponse.value = data
    }
}