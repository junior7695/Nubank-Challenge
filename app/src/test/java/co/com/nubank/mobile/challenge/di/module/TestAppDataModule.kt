package co.com.nubank.mobile.challenge.di.module

import co.com.nubank.mobile.challenge.infrastructure.api.service.ApiService
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import dagger.Module
import dagger.Provides
import io.mockk.mockk
import javax.inject.Singleton

@Module
class TestAppDataModule {

    @Singleton
    @Provides
    internal fun provideTasksRemoteDataSource(
        apiService: ApiService
    ): DataSource = mockk()
}