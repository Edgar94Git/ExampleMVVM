package com.ereyes.examplemvvm.data.network

import com.ereyes.examplemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data.network
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 2:58 PM
 * All rights reserved 2023.
 ****/
class QuoteService @Inject constructor(private val api: QuoteApiClient) {

    suspend fun getQuotes(): List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response: Response<List<QuoteModel>> = api.getAllQuote()
            response.body() ?: emptyList()
        }
    }
}