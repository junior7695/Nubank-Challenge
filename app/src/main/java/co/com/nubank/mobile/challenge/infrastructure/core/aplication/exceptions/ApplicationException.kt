package co.com.nubank.mobile.challenge.infrastructure.core.aplication.exceptions

import java.lang.RuntimeException

open class ApplicationException : RuntimeException {

    constructor(message: String, cause: Throwable) : super(message, cause)

    constructor(message: String) : super(message)

}