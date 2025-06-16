package net.orgaprop.controlsecuv2.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.orgaprop.controlsecuv2.data.local.database.ControlSecuDatabase
import net.orgaprop.controlsecuv2.data.local.database.dao.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ControlSecuDatabase {
        return Room.databaseBuilder(
            context,
            ControlSecuDatabase::class.java,
            "controlsecu_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideUserDao(database: ControlSecuDatabase): UserDao = database.userDao()

    @Provides
    fun provideAgencyDao(database: ControlSecuDatabase): AgencyDao = database.agencyDao()

    @Provides
    fun provideGroupingDao(database: ControlSecuDatabase): GroupingDao = database.groupingDao()

    @Provides
    fun provideEntryDao(database: ControlSecuDatabase): EntryDao = database.entryDao()

    @Provides
    fun provideGridDao(database: ControlSecuDatabase): GridDao = database.gridDao()

    @Provides
    fun provideControlDao(database: ControlSecuDatabase): ControlDao = database.controlDao()

    @Provides
    fun provideControlPointDao(database: ControlSecuDatabase): ControlPointDao = database.controlPointDao()

    @Provides
    fun provideCommentDao(database: ControlSecuDatabase): CommentDao = database.commentDao()

    @Provides
    fun providePhotoDao(database: ControlSecuDatabase): PhotoDao = database.photoDao()

}
