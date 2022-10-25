package co.com.nubank.mobile.challenge

import co.com.nubank.mobile.challenge.MainApplication
import co.com.nubank.mobile.challenge.di.component.AppComponent
import co.com.nubank.mobile.challenge.di.component.TestAppComponent
import co.com.nubank.mobile.challenge.di.component.DaggerTestAppComponent

class TestMainApplication : MainApplication() {

    override fun initializeDaggerComponent(): AppComponent {
        val component: TestAppComponent = DaggerTestAppComponent.factory()
            .create(this)

        component.inject(this)

        return component
    }

}