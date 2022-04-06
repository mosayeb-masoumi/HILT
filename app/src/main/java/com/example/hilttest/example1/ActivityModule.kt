package com.example.hilttest.example1

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ActivityModule {

    @Singleton
    @Provides
    fun provideThirdClass() : ThirdClass {
        val thirdClass = ThirdClass()
        return thirdClass
    }
}