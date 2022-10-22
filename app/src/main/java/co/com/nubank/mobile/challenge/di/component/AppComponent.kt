package co.com.nubank.mobile.challenge.di.component

import android.content.Context
import co.com.nubank.mobile.challenge.MainApplication
import co.com.nubank.mobile.challenge.di.ViewModelBuilderModule
import co.com.nubank.mobile.challenge.di.modules.ActivityBuildersModule
import co.com.nubank.mobile.challenge.di.modules.DataModule
import co.com.nubank.mobile.challenge.di.modules.RepositoryModule
import co.com.nubank.mobile.challenge.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
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
interface AppComponent : AndroidInjector<DaggerApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun inject(app: MainApplication)
}