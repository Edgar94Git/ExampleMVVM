package com.ereyes.examplemvvm.domain

import com.ereyes.examplemvvm.data.QuoteRepository
import com.ereyes.examplemvvm.data.model.QuoteModel
import javax.inject.Inject

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.domain
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 3:19 PM
 * All rights reserved 2023.
 ****/
class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<QuoteModel>? {
        return repository.getAllQuotes()
    }
}