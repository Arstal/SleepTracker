package com.qihaocai.sleeptracker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepDao {
    @Query("SELECT * FROM Sleep_table")
    fun getAll(): Flow<List<SleepEntity>>

    @Insert
    fun insertAll(Sleep: List<SleepEntity>)

    @Insert
    fun insert(Sleep: SleepEntity)

    @Query("DELETE FROM Sleep_table")
    fun deleteAll()
}