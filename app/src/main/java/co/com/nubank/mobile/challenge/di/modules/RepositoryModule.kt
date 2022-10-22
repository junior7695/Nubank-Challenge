package co.com.nubank.mobile.challenge.di.modules

import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepository
import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RepositoryModule {

    @Singleton
    @Binds
    fun bindRepository(shortLinkRepository: ShortLinkRepositoryImpl): ShortLinkRepository
}