package com.ereyes.examplemvvm.domain

import com.ereyes.examplemvvm.data.QuoteRepository
import com.ereyes.examplemvvm.domain.model.Quote
import javax.inject.Inject

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.domain
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 4:07 PM
 * All rights reserved 2023.
 ****/
class GetRandomQuoteUseCase @Inject constructor(private val repository: QuoteRepository) {
    suspend operator fun invoke(): Quote? {
        val quotes: List<Quote> = repository.getAllQuoteFromDataBase()
        if(quotes.isNotEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}