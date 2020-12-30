package com.example.sleepcheck.dataModel

import androidx.room.Database
import androidx.room.DatabaseView
import androidx.room.RoomDatabase

@Database(entities = [Sleep::class], version = 1)
abstract class SleepDataBase : RoomDatabase() {
    abstract fun getSleepDao(): SleepDao
}