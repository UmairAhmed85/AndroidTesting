package com.androidtesting.util

import ProductsApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiTest {
    lateinit var mockWebServer: MockWebServer
    lateinit var productsApi: ProductsApi

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        productsApi = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsApi::class.java)
    }

    @Test
    fun testGetProducts() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = productsApi.getProducts()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, response.body()!!.isEmpty())
    }

    @Test
    fun testGetProducts_returnProducts() = runTest {
        val mockResponse = MockResponse()
        val content = FileReader.readFileResource("/response.json")
        mockResponse.setResponseCode(200)
        mockResponse.setBody(content)
        mockWebServer.enqueue(mockResponse)

        val response = productsApi.getProducts()
        mockWebServer.takeRequest()
        Assert.assertEquals(false, response.body()!!.isEmpty())
        Assert.assertEquals(4, response.body()!!.size)
    }

    @Test
    fun testGetProducts_returnError() = runTest {
        val mockResponse = MockResponse()
        mockResponse.setResponseCode(400)
        mockResponse.setBody("Page Not Found")
        mockWebServer.enqueue(mockResponse)

        val response = productsApi.getProducts()
        mockWebServer.takeRequest()
        Assert.assertEquals(true, !response.isSuccessful)
        Assert.assertEquals(400, response.code())
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}