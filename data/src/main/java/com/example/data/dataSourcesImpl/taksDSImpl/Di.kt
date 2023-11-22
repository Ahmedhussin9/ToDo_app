package com.example.data.dataSourcesImpl.taksDSImpl

import android.content.Context
import com.example.data.dataSources.TasksDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    abstract fun provideTasksDataSource(
        dataSourceImpl: TasksDataSourceImpl
    ):TasksDataSource

    @Binds
    abstract fun provideContext(
       @ApplicationContext context: Context
    ):Context
}