package com.ereyes.examplemvvm.ui.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ereyes.examplemvvm.domain.GetQuotesUseCase
import com.ereyes.examplemvvm.domain.GetRandomQuoteUseCase
import com.ereyes.examplemvvm.domain.model.Quote
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/****
 * Project: ExampleMVVM
 * From: com.ereyes.examplemvvm.ui.viewModel
 * Created by Edgar Reyes Gonzalez on 3/6/2023 at 10:11 AM
 * All rights reserved 2023.
 */
@ExperimentalCoroutinesApi
internal class QuoteViewModelTest{

    @RelaxedMockK
    private lateinit var getQuotesUseCase: GetQuotesUseCase
    @RelaxedMockK
    private lateinit var getRandomQuoteUseCase: GetRandomQuoteUseCase

    private lateinit var quoteViewModel: QuoteViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        quoteViewModel = QuoteViewModel(getQuotesUseCase, getRandomQuoteUseCase)
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter(){
        Dispatchers.resetMain()
    }

    @Test
    fun `When the view model is created for the first time, get all quotes and set the first value`() = runTest {
        //Given
        val quotes = listOf(
            Quote("This is a test", "Edgar Reyes Gonzalez"),
            Quote("This is a test viewModel", "Edgar Reyes Gonzalez")
        )
        coEvery {  getQuotesUseCase() } returns quotes

        //When
        quoteViewModel.onCreate()

        //Then
        assert(quoteViewModel.getQuoteModel().value == quotes.first())
    }

    @Test
    fun `When randomQuoteUseCase return a quote set on the live data`() = runTest {

        //Given
        val quote: Quote = Quote("This is a test", "Edgar Reyes Gonzalez")
        coEvery { getRandomQuoteUseCase() } returns quote

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.getQuoteModel().value == quote)
    }

    @Test
    fun `If randomQuoteUseCase return null, keep the last value`() = runTest {
        //Give
        val quote: Quote = Quote("This is a test", "Edgar Reyes Gonzalez")
        quoteViewModel.getQuoteModel().value = quote
        coEvery { getRandomQuoteUseCase() } returns null

        //When
        quoteViewModel.randomQuote()

        //Then
        assert(quoteViewModel.getQuoteModel().value == quote)
    }
}