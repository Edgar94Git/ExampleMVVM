package com.ereyes.examplemvvm.di

import android.content.Context
import androidx.room.Room
import com.ereyes.examplemvvm.data.dataBase.QuoteDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.di
 * Created by Edgar Reyes Gonzalez on 3/5/2023 at 5:57 PM
 * All rights reserved 2023.
 ****/
@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, QuoteDataBase::class.java, "BdQuote").build()

    @Singleton
    @Provides
    fun provideQuoteDao(bd: QuoteDataBase) = bd.getQuoteDao()
}