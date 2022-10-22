package co.com.nubank.mobile.challenge.infrastructure.api.dtos.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetShortLinkResponseDTO(
    @SerializedName("url") val url: String
) : Parcelable
