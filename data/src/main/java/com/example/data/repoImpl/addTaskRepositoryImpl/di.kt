package com.example.data.repoImpl.addTaskRepositoryImpl

import com.example.domian.repository.addTaskRepo.AddTaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
    @Binds
    abstract fun provideAddTaskRepo(
        addTaskRepoImpl: AddTaskRepoImpl
    ):AddTaskRepository
}