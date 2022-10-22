package co.com.nubank.mobile.challenge

import co.com.nubank.mobile.challenge.di.component.AppComponent
import co.com.nubank.mobile.challenge.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

open class MainApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        initializeDaggerComponent()


    open fun initializeDaggerComponent(): AppComponent {
        val component: AppComponent = DaggerAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }
}