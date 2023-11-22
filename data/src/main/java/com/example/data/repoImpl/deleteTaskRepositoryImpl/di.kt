package com.example.data.repoImpl.deleteTaskRepositoryImpl

import com.example.domian.repository.deleteTaskRepo.DeleteTaskRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
 @Binds
 abstract fun provideDeleteTaskRepo(
      deleteTaskRepositoryImpl: DeleteTaskRepositoryImpl
 ):DeleteTaskRepository
}