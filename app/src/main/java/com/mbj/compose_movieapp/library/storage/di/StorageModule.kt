package com.mbj.compose_movieapp.library.storage.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.mbj.compose_movieapp.library.storage.IStorage
import com.mbj.compose_movieapp.library.storage.StorageManager
import com.mbj.compose_movieapp.library.storage.helpers.DataConverter
import com.mbj.compose_movieapp.library.storage.helpers.DataEncoding
import com.mbj.compose_movieapp.library.storage.prefs.SharedPrefsStorageProvider
import com.mbj.compose_movieapp.library.storage.prefs.StorageProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Provides
    fun bindOnDiscStorage(
        storage: StorageProvider,
        converter: DataConverter,
        encoding: DataEncoding
    ): IStorage = StorageManager(storage, converter, encoding)

    @Provides
    fun provideSharePrefStorageProvider(provider: SharedPrefsStorageProvider): StorageProvider =
        provider

}
