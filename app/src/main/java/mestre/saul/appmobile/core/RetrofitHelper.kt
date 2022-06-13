package mestre.saul.appmobile.core

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private var token: String = ""
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.31.93:3000")
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .build()
    }
    private fun getClient(): OkHttpClient{
        val client= OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .build()

        return client
    }
}