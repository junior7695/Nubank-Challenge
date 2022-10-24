package co.com.nubank.mobile.challenge.infrastructure.api

import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.Protocol
import okhttp3.ResponseBody
import okhttp3.MediaType

class ShortLinkInterceptorApi : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val uri = chain.request().url().uri().toString()

        val responseString = when {

            uri.endsWith("api/alias/111111") -> getLinkByAliasMocked111111

            uri.endsWith("api/alias") -> postShortLink

            else -> ""
        }

        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(responseString)
            .body(
                ResponseBody.create(
                    MediaType.parse("application/json"),
                    responseString.toByteArray()
                )
            )
            .addHeader("content-type", "application/json")
            .build()
    }
}

const val getLinkByAliasMocked111111 = """
{
    "url": "https://www.youtube.com/"
}
"""

const val postShortLink = """
{
    "alias": "111111",
    "_links": {
        "self": "https://www.youtube.com/",
        "short": "https://url-shortener-nu.herokuapp.com/short/111111"
    }
}
"""