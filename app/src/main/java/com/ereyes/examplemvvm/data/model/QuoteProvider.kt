package com.ereyes.examplemvvm.data.model

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.model
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 1:41 PM
 * All rights reserved 2023.
 ****/
class QuoteProvider {
    companion object{
        var quotes: List<QuoteModel> = emptyList()
    }
}