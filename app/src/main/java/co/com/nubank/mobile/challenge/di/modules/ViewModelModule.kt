package co.com.nubank.mobile.challenge.di.modules

import androidx.lifecycle.ViewModel
import co.com.nubank.mobile.challenge.di.ViewModelKey
import co.com.nubank.mobile.challenge.ui.landing.viewmodel.ShortLinkViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ShortLinkViewModel::class)
    fun bindPostViewModel(shortLinkViewModel: ShortLinkViewModel): ViewModel

}