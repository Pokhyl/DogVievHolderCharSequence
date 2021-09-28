package com.example.dogvievholdercharsequence

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class Dog(var name : String , var age: Int , var breed: String) {
}
class Foo @Inject constructor(){

   var list = mutableListOf<Dog>(
    Dog("Eva", 4, "york"),
    Dog("sky", 4, "york"),
    Dog("Barbor", 4, "york"),
    Dog("Vasy", 4, "york"),
    Dog("tjjkghg", 4, "york"),
    Dog("Dog", 4, "york"),
    Dog("Misha", 4, "york"),
    Dog("Fruzy", 4, "york"),
    Dog("Druzhok", 4, "york"),
    Dog("Sarik", 4, "york"),
    Dog("Bobik", 4, "york"),
    Dog("ZhuZhik", 4, "york"),)

    fun getDogList(): MutableList<Dog>{
        return list
    }
}

@Module
internal object SimpleModule {
    @Provides
    fun provideFoo(): Foo {
        return Foo()
    }
}

@Singleton
@Component(modules = [SimpleModule::class])
interface SimpleComponent {
   //fun foo(): Foo?
    fun inject(activity: MainActivity)
}