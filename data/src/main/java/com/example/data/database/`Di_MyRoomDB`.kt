package com.example.data.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class `Di_MyRoomDB` {
    @Provides
    fun provideTasksDao(
        myRoomDB: MyRoomDB
    ):TasksDao{
        return myRoomDB.TasksDao()
    }
    @Singleton
    @Provides
    fun provideMyRoomDB(@ApplicationContext context: Context):MyRoomDB{
        return Room.databaseBuilder(
            context,
            MyRoomDB::class.java,"TasksDataBase"

        ).fallbackToDestructiveMigration()
            .build()

    }
}