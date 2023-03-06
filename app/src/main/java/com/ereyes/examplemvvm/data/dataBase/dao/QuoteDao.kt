package com.ereyes.examplemvvm.data.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ereyes.examplemvvm.data.dataBase.entities.QuoteEntity

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.data.dataBase.dao
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 5:43 PM
 * All rights reserved 2023.
 ****/
@Dao
interface QuoteDao {

    @Query("SELECT * FROM T_Quote ORDER BY author DESC")
    suspend fun getAllQuote(): List<QuoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllQuote(quotes: List<QuoteEntity>)

    @Query("DELETE FROM T_Quote")
    suspend fun deleteAllQuotes()
}