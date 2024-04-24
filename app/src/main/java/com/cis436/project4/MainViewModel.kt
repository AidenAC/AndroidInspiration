package com.cis436.project4

import androidx.lifecycle.ViewModel
import org.json.JSONArray
import org.json.JSONObject

class MainViewModel : ViewModel() {
    private lateinit var quote : JSONObject

    fun setQuote(json : String) {
        val array = JSONArray(json)
        quote = array.getJSONObject(0)
    }
    fun getQuote() : String {
        return quote.get("q").toString()
    }
}