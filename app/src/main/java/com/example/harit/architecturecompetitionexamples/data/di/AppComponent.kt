package com.example.harit.architecturecompetitionexamples.data.di

import com.example.harit.architecturecompetitionexamples.ui.LoginPage.SignupFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
        modules = arrayOf(
                AppModule::class,
                UserRepositoryModule::class
        )
)
interface AppComponent {

    fun inject(fragment : SignupFragment)

}