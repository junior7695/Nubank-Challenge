package co.com.nubank.mobile.challenge.infrastructure.api.dtos.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostShortLinkResponseDTO(
    @SerializedName("alias") val alias: String,
    @SerializedName("_links") val links: LinksDTO
) : Parcelable
