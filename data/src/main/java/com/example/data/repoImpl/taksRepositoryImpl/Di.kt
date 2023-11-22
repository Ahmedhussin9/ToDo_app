package com.example.data.repoImpl.taksRepositoryImpl

import com.example.domian.repository.loadtaskrepo.TasksRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class Di {
    @Binds
    abstract fun provideTasksRepositoryImpl(
        tasksRepositoryImpl: TasksRepositoryImpl
    ):TasksRepository
}