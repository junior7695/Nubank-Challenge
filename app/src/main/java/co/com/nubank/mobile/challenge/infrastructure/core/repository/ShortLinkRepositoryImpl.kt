package co.com.nubank.mobile.challenge.infrastructure.core.repository

import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link
import co.com.nubank.mobile.challenge.infrastructure.core.aplication.exceptions.ApplicationException
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import co.com.nubank.mobile.challenge.infrastructure.core.converters.Result
import javax.inject.Inject

internal class ShortLinkRepositoryImpl @Inject constructor(
    private val remoteDataSource: DataSource
) : ShortLinkRepository {

    override suspend fun postShortLink(url: String): Result<Link> {
        return try {
            val response = remoteDataSource.postShortLink(url)

            val linkEntity = response.body()!!.toEntity()

            Result.Success(linkEntity)

        } catch (e: ApplicationException) {
            Result.Error(e)
        }
    }

    override suspend fun getLinkByAlias(alias: String): Result<String> {
        return try {
            val response = remoteDataSource.getLinkByAlias(alias)

            val link = response.body()!!.url

            Result.Success(link)

        } catch (e: ApplicationException) {
            Result.Error(e)
        }
    }
}