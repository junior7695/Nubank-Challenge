package co.com.nubank.mobile.challenge.di.modules

import co.com.nubank.mobile.challenge.di.scopes.ActivityScope
import co.com.nubank.mobile.challenge.ui.landing.activity.LandingActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface ActivityBuildersModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    fun contributeLandingActivity(): LandingActivity

}