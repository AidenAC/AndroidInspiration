package com.cis436.project4

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private lateinit var quote : String

    fun setQuote(quote : String) {
        this.quote = quote
    }
    fun getQuote() : String {
        return quote
    }
}