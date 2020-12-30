package com.example.sleepcheck.dataModel

import android.content.Context
import androidx.room.Room

object SleepDb {
    fun getSleepDb(context: Context): SleepDataBase {
        return Room.databaseBuilder(context, SleepDataBase::class.java, "sleep-db")
            .allowMainThreadQueries().build()
    }
}