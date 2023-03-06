package com.ereyes.examplemvvm.data.dataBase.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ereyes.examplemvvm.domain.model.Quote

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data.dataBase.entities
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 5:36 PM
 * All rights reserved 2023.
 ****/
@Entity(tableName = "T_Quote")
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name="quote") val quote: String,
    @ColumnInfo(name="author") val author: String
)

fun Quote.toDataBase() = QuoteEntity( quote = quote, author = author)