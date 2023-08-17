package com.example.homefurniture.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import javax.inject.Singleton

@Module
@InstallIn()  //this will be define the life of dependency in this module
object AppModule {

    @Provides
    @Singleton

    fun provideFirebaseAuth()=FirebaseAuth.getInstance()
}