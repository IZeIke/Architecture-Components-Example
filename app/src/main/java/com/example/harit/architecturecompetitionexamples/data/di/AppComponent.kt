package com.example.harit.architecturecompetitionexamples.data.di

import com.example.harit.architecturecompetitionexamples.ui.FeedPage.FeedFragment
import com.example.harit.architecturecompetitionexamples.ui.FeedPage.UserFeedViewModel
import com.example.harit.architecturecompetitionexamples.ui.LoginPage.LoginActivity
import com.example.harit.architecturecompetitionexamples.ui.LoginPage.SignupFragment
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
        modules = [AppModule::class, UserRepositoryModule::class]
)
interface AppComponent {

    fun inject(fragment : SignupFragment)
    fun inject(activity : LoginActivity)
    fun inject(feedFragment: FeedFragment)
    fun inject(viewModel: UserFeedViewModel)

}