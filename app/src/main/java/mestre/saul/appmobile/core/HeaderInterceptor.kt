package mestre.saul.appmobile.core

import mestre.saul.appmobile.data.model.Token
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            "Authorization", Token.token
        )
            .build()
        return chain.proceed(request = request)
    }
}