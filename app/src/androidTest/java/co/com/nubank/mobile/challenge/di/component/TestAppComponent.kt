package co.com.nubank.mobile.challenge.di.component

import android.content.Context
import co.com.nubank.mobile.challenge.di.ViewModelBuilderModule
import co.com.nubank.mobile.challenge.di.modules.ActivityBuildersModule
import co.com.nubank.mobile.challenge.di.modules.DataModule
import co.com.nubank.mobile.challenge.di.modules.NetworkModule
import co.com.nubank.mobile.challenge.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class,
        DataModule::class,
        RepositoryModule::class,
        ViewModelBuilderModule::class,
        ActivityBuildersModule::class]
)
interface TestAppComponent : AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): TestAppComponent
    }
}