package co.com.nubank.mobile.challenge.infrastructure.core.data_source

import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.GetShortLinkResponseDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.PostShortLinkResponseDTO
import retrofit2.Response

internal interface DataSource {

    suspend fun postShortLink(url: String): Response<PostShortLinkResponseDTO>

    suspend fun getLinkByAlias(alias: String): Response<GetShortLinkResponseDTO>

}