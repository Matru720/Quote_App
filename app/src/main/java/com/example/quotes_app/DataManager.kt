package com.example.quotes_app

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.example.quotes_app.Models.Quote
import com.google.gson.Gson
import java.nio.charset.Charset

object DataManager {
    var data = emptyArray<Quote>()
    var currentQuote: Quote? = null
    var isDataLoaded = mutableStateOf(false)

    var currentPage = mutableStateOf(Pages.Listings)

    fun loadAssetsFromFile(context: Context) {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charset.forName("UTF-8"))
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)
        isDataLoaded.value = true
    }
    fun switchPages(quote: Quote?){
        if (currentPage.value == Pages.Listings){
            currentQuote = quote
            currentPage.value = Pages.Details
        }
        else{
            currentPage.value = Pages.Listings
        }
    }
}