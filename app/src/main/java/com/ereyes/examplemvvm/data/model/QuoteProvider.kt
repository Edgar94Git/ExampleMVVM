package com.ereyes.examplemvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.model
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 1:41 PM
 * All rights reserved 2023.
 ****/
@Singleton
class QuoteProvider @Inject constructor() {
    var quotes: List<QuoteModel> = emptyList()
}