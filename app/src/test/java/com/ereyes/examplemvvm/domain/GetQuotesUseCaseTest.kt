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
 * Created by Edgar Reyes Gonzalez on 3/6/2023 at 7:45 AM
 * All rights reserved 2023.
 */
internal class GetQuotesUseCaseTest{

    @RelaxedMockK
    private lateinit var quoteRepository: QuoteRepository
    private lateinit var getQuotesUseCase: GetQuotesUseCase

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        getQuotesUseCase = GetQuotesUseCase(quoteRepository)
    }

    @Test
    fun `When the API doesn't return anything, then get values from the database`() = runBlocking{
        //Given
        coEvery { quoteRepository.getAllQuotesFromApi() } returns emptyList()

        //When
        getQuotesUseCase()

        //Then
        coVerify(exactly = 1) { quoteRepository.getAllQuoteFromDataBase() }
    }

    @Test
    fun `When the API returns something, then get values from the API`() = runBlocking{
        //Given
        val quotes = listOf(Quote("This is a test", "Edgar Reyes Gonzalez"))
        coEvery { quoteRepository.getAllQuotesFromApi() } returns quotes

        //When
        val response = getQuotesUseCase()

        //Then
        coVerify(exactly = 1) { quoteRepository.clearQuotes() }
        coVerify(exactly = 1) { quoteRepository.insertAllQuote(any()) }
        coVerify(exactly = 0) { quoteRepository.getAllQuoteFromDataBase() }
        assert(quotes == response)
    }
}