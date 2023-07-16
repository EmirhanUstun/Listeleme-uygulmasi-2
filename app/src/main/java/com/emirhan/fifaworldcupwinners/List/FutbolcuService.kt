package com.h5210060_emirhan.ustun_final.List

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object FutbolcuService {

    val baseUrl = "https://raw.githubusercontent.com/EmirhanUstun/H5210060-EmirhanUstun/main"

    fun build(): FutbolcuApi {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()

        return retrofit.create(FutbolcuApi::class.java)
    }
}