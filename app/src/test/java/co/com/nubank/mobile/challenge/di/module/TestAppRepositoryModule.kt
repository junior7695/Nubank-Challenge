package co.com.nubank.mobile.challenge.di.module

import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepository
import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

@Module
internal class TestAppRepositoryModule {

    @Singleton
    @Provides
    fun provideTasksShortLinkRepository(shortLinkRepository: ShortLinkRepositoryImpl): ShortLinkRepository = mockk()
}