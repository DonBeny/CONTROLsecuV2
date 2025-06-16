package net.orgaprop.controlsecuv2.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.orgaprop.controlsecuv2.data.repository.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun bindHierarchyRepository(
        hierarchyRepositoryImpl: HierarchyRepositoryImpl
    ): HierarchyRepository

    @Binds
    @Singleton
    abstract fun bindGridRepository(
        gridRepositoryImpl: GridRepositoryImpl
    ): GridRepository

    @Binds
    @Singleton
    abstract fun bindControlRepository(
        controlRepositoryImpl: ControlRepositoryImpl
    ): ControlRepository

    @Binds
    @Singleton
    abstract fun bindSyncRepository(
        syncRepositoryImpl: SyncRepositoryImpl
    ): SyncRepository

}
