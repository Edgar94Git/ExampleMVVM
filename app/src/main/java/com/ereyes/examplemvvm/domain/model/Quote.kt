package com.ereyes.examplemvvm.domain.model

import com.ereyes.examplemvvm.data.dataBase.entities.QuoteEntity
import com.ereyes.examplemvvm.data.model.QuoteModel

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.domain.model
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 6:08 PM
 * All rights reserved 2023.
 ****/
data class Quote(val quote: String, val author: String)

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)