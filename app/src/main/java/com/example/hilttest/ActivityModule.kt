package com.example.hilttest

import com.example.hilttest.example1.ThirdClass
import com.example.hilttest.example2.MyClass2
import com.example.hilttest.recyclerView.MyAdapter
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

    @Singleton
    @Provides
    fun provideMyClass2() : MyClass2 {
        val myClass2 = MyClass2()
        return myClass2
    }


    //    @Provides
//    @Singleton
//    fun provideAdapter(list: MutableList<String>, @ActivityContext context: Context): MyAdapter {
//        return MyAdapter(list, context)
//    }

    @Provides
    @Singleton
    fun provideAdapter(): MyAdapter {
        return MyAdapter()
    }

}