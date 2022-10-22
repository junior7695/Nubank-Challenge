package co.com.nubank.mobile.challenge.ui.landing.extensions

import android.util.Patterns
import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link

internal fun String.isValidUrl(): Boolean =
    (this.isNotBlank() && Patterns.WEB_URL.matcher(this).matches())

internal fun List<Link>?.containThisLink(link: String): Boolean =
    this?.any { it.getSelfLink().equals(link, true) } ?: false