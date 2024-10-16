package com.nelalexxx.myfoodapp.di.modules

import android.content.Context
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.app
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Named("Firebase_app")
    fun provideFirebaseApp(): FirebaseApp {
        return Firebase.app // or FirebaseApp.initializeApp(context) if needed
    }
}