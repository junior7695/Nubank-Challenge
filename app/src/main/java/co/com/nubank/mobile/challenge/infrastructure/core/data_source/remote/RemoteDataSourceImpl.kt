package co.com.nubank.mobile.challenge.infrastructure.core.data_source.remote

import co.com.nubank.mobile.challenge.infrastructure.api.dtos.request.PostShortLinkRequestDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.GetShortLinkResponseDTO
import co.com.nubank.mobile.challenge.infrastructure.api.dtos.response.PostShortLinkResponseDTO
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import co.com.nubank.mobile.challenge.infrastructure.api.service.ApiService
import retrofit2.Response
import javax.inject.Inject

internal class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : DataSource {

    override suspend fun postShortLink(url: String): Response<PostShortLinkResponseDTO> {
        val request = PostShortLinkRequestDTO(url)

        return apiService.postShortLink(request)
    }

    override suspend fun getLinkByAlias(alias: String): Response<GetShortLinkResponseDTO> =
        apiService.getLinkByAlias(alias)
}