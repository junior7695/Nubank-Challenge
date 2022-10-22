package co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities

internal class Link(
    private val alias: String,
    private val self: String,
    private val short: String
) {

    internal fun getAlias() = alias

    internal fun getSelfLink() = self

    internal fun getShortLink() = short
}