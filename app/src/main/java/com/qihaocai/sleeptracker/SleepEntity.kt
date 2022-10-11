package com.qihaocai.sleeptracker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sleep_table")
data class SleepEntity(

    @ColumnInfo(name = "Hours") val Hours: String?,
    @ColumnInfo(name = "Date") val Date: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)