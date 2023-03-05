package com.ereyes.examplemvvm.data.network

import com.ereyes.examplemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data.network
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 2:51 PM
 * All rights reserved 2023.
 ****/
interface QuoteApiClient {
    @GET("/.json")
    suspend fun getAllQuote(): Response<List<QuoteModel>>
}