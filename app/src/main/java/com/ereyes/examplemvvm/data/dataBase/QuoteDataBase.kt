package com.ereyes.examplemvvm.data.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ereyes.examplemvvm.data.dataBase.dao.QuoteDao
import com.ereyes.examplemvvm.data.dataBase.entities.QuoteEntity

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data.dataBase
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 5:55 PM
 * All rights reserved 2023.
 ****/
@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}