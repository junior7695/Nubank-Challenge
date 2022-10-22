package co.com.nubank.mobile.challenge.infrastructure.api.service

import co.com.nubank.mobile.challenge.infrastructure.api.dtos.request.PostShortLinkRequestDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.GetShortLinkResponseDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.PostShortLinkResponseDTO
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Body

internal interface ApiService {

    companion object {
        internal const val IO_TIMEOUT = 30L
        internal const val BASE_URL = "https://url-shortener-nu.herokuapp.com/"
    }

    @POST("api/alias")
    suspend fun postShortLink(
        @Body request: PostShortLinkRequestDTO
    ): Response<PostShortLinkResponseDTO>

    @GET("api/alias/{alias}")
    suspend fun getLinkByAlias(
        @Path("alias") alias: String
    ): Response<GetShortLinkResponseDTO>

}