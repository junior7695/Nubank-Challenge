package co.com.nubank.mobile.challenge.infrastructure.core.repository

import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link
import co.com.nubank.mobile.challenge.infrastructure.core.converters.Result

internal interface ShortLinkRepository {

    suspend fun postShortLink(url: String): Result<Link>

    suspend fun getLinkByAlias(alias: String): Result<String>

}