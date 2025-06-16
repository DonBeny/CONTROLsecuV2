package net.orgaprop.controlsecuv2.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.orgaprop.controlsecuv2.core.logging.AppLogger
import net.orgaprop.controlsecuv2.core.logging.LoggingInterface
import net.orgaprop.controlsecuv2.core.preferences.PreferencesManager
import net.orgaprop.controlsecuv2.core.preferences.SecurePreferences
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    @Singleton
    fun provideSecurePreferences(@ApplicationContext context: Context): SecurePreferences {
        return SecurePreferences(context)
    }

    @Provides
    @Singleton
    fun providePreferencesManager(@ApplicationContext context: Context): PreferencesManager {
        return PreferencesManager(context)
    }

    @Provides
    @Singleton
    fun provideLogger(): LoggingInterface = AppLogger()

}
