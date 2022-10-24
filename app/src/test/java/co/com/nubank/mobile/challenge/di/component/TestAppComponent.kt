package co.com.nubank.mobile.challenge.di.component

import android.content.Context
import co.com.nubank.mobile.challenge.application.TestMainApplication
import co.com.nubank.mobile.challenge.di.module.TestAppDataModule
import co.com.nubank.mobile.challenge.di.ViewModelBuilderModule
import co.com.nubank.mobile.challenge.di.module.TestAppNetworkModule
import co.com.nubank.mobile.challenge.di.modules.ActivityBuildersModule
import co.com.nubank.mobile.challenge.di.modules.RepositoryModule
import co.com.nubank.mobile.challenge.infrastructure.api.ApiServiceTest
import co.com.nubank.mobile.challenge.infrastructure.core.repository.ShortLinkRepositoryImplTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        TestAppNetworkModule::class,
        TestAppDataModule::class,
        RepositoryModule::class,
        ViewModelBuilderModule::class,
        ActivityBuildersModule::class]
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }

    fun inject(app: TestMainApplication)

    fun inject(test: ShortLinkRepositoryImplTest)

    fun inject(api: ApiServiceTest)
}