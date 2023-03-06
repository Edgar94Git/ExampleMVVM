package com.ereyes.examplemvvm.domain

import com.ereyes.examplemvvm.data.QuoteRepository
import com.ereyes.examplemvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.domain
 * Created by Edgar Reyes Gonzalez on 3/6/2023 at 9:03 AM
 * All rights reserved 2023.
 */
internal class GetRandomQuoteUseCaseTest{

    @RelaxedMockK
    private lateinit var quoterepository: QuoteRepository
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getRandomQuoteUseCase = GetRandomQuoteUseCase(quoterepository)
    }

    @Test
    fun `When the database is empty returns null`() = runBlocking{
        //Given
        coEvery { quoterepository.getAllQuoteFromDataBase() } returns emptyList()

        //When
        val response = getRandomQuoteUseCase()

        //Then
        assert(response == null)
    }

    @Test
    fun `When the database is not empty, then return quote`() = runBlocking {
        //Given
        val quotes = listOf(Quote("When the database is not empty, then return quote", "Edgar Reyes Gonzalez"))
        coEvery { quoterepository.getAllQuoteFromDataBase() } returns quotes

        //When
        val response = getRandomQuoteUseCase()

        //Then
        assert(response == quotes.first())
    }
}