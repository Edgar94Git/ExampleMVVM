package com.ereyes.examplemvvm.data

import com.ereyes.examplemvvm.data.dataBase.dao.QuoteDao
import com.ereyes.examplemvvm.data.dataBase.entities.QuoteEntity
import com.ereyes.examplemvvm.data.model.QuoteModel
import com.ereyes.examplemvvm.data.network.QuoteService
import com.ereyes.examplemvvm.domain.model.Quote
import com.ereyes.examplemvvm.domain.model.toDomain
import javax.inject.Inject

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 3:10 PM
 * All rights reserved 2023.
 ****/
class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote>{
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuoteFromDataBase(): List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuote()
        return response.map { it.toDomain() }
    }

    suspend fun insertAllQuote(quotes: List<QuoteEntity>){
        quoteDao.insertAllQuote(quotes)
    }

    suspend fun clearQuotes() {
        quoteDao.deleteAllQuotes()
    }
}