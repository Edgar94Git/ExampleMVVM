package com.ereyes.examplemvvm.data.model

import com.google.gson.annotations.SerializedName

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.model
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 1:39 PM
 * All rights reserved 2023.
 ****/
data class QuoteModel(
    @SerializedName("quote") val quote: String,
    @SerializedName("author") val author: String
)