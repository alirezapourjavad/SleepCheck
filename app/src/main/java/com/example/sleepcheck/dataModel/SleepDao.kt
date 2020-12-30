package com.example.sleepcheck.dataModel

import androidx.room.*

@Dao
interface SleepDao {
    @Insert
    fun insertSleep(sleep: Sleep)
    @Delete
    fun deleteSleep(sleep: Sleep)
    @Update
    fun updateSleep(sleep: Sleep)
    @Query("SELECT * FROM sleep_table WHERE sleep_id = :id")
    fun getSleep (id:Int):Sleep
    @Query("SELECT * FROM sleep_table")
    fun getSleepList ():List<Sleep>
    @Query("SELECT * FROM sleep_table ORDER BY sleep_id LIMIT 1")
    fun getLastSleep ():Sleep
}
