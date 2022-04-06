package com.example.hilttest.example2

import com.example.hilttest.example1.ThirdClass
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
    fun provideMyClass2() : MyClass2 {
        val myClass2 = MyClass2()
        return myClass2
    }
}