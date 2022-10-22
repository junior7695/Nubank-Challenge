package co.com.nubank.mobile.challenge.infrastructure.api.dtos.request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostShortLinkRequestDTO(
    @SerializedName("url") val url: String
) : Parcelable
