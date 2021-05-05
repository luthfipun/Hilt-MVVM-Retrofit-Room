package github.luthfipun.hiltmvi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import github.luthfipun.hiltmvi.repository.MainRepository
import github.luthfipun.hiltmvi.repository.MainRepositoryImpl
import github.luthfipun.hiltmvi.repository.local.LocalRepository
import github.luthfipun.hiltmvi.repository.local.LocalRepositoryImpl
import github.luthfipun.hiltmvi.repository.remote.RemoteRepository
import github.luthfipun.hiltmvi.repository.remote.RemoteRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(mainRepositoryImpl: MainRepositoryImpl): MainRepository =
        mainRepositoryImpl

    @Singleton
    @Provides
    fun provideRemoteRepository(remoteRepositoryImpl: RemoteRepositoryImpl): RemoteRepository =
        remoteRepositoryImpl

    @Singleton
    @Provides
    fun provideLocalRepository(localRepositoryImpl: LocalRepositoryImpl): LocalRepository =
        localRepositoryImpl
}