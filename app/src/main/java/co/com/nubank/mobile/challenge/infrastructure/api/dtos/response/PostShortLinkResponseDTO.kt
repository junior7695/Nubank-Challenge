package co.com.nubank.mobile.challenge.infrastructure.api.dtos.response

import android.os.Parcelable
import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostShortLinkResponseDTO(
    @SerializedName("alias") val alias: String,
    @SerializedName("_links") val links: LinksDTO
) : Parcelable {

    internal fun toEntity() = Link(alias, links.self, links.short)

}
