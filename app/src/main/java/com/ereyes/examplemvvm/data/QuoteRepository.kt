package com.ereyes.examplemvvm.data

import com.ereyes.examplemvvm.data.model.QuoteModel
import com.ereyes.examplemvvm.data.model.QuoteProvider
import com.ereyes.examplemvvm.data.network.QuoteService

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 3:10 PM
 * All rights reserved 2023.
 ****/
class QuoteRepository {
    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}