package com.example.data.repoImpl.markAsDoneRepoImpl

import com.example.domian.repository.deleteTaskRepo.DeleteTaskRepository
import com.example.domian.repository.markAsDone.MarkAsDoneRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class di {
 @Binds
 abstract fun provideDeleteTaskRepo(
     markAsDoneRepositoryImpl: MarkAsDoneRepositoryImpl
 ):MarkAsDoneRepository
}