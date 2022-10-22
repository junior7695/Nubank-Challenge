package co.com.nubank.mobile.challenge.infrastructure.core.aplication.exceptions

class NetworkingException : ApplicationException {

    constructor(message: String, cause: Throwable) : super(message, cause)

}