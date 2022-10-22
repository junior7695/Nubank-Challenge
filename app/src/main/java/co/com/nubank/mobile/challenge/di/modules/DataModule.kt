package co.com.nubank.mobile.challenge.di.modules

import co.com.nubank.mobile.challenge.infrastructure.api.service.ApiService
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.DataSource
import co.com.nubank.mobile.challenge.infrastructure.core.data_source.remote.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    internal fun provideTasksRemoteDataSource(
        apiService: ApiService
    ): DataSource {
        return RemoteDataSourceImpl(apiService)
    }
}