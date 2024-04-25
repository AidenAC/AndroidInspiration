package com.cis436.project4

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel : ViewModel() {
    private var quote : MutableLiveData<JSONObject> = MutableLiveData(JSONObject())

    fun setQuote(json : String) {
        val array = JSONArray(json)
        quote.value = array.getJSONObject(0)
    }
    fun getQuote() : MutableLiveData<JSONObject> {
        return quote
    }
}