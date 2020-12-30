package com.example.sleepcheck.dataModel

import android.content.Context

class DbRepository (context: Context) {
    private val sleepDao = SleepDb.getSleepDb(context).getSleepDao()

    fun insertSleep (sleep: Sleep){
        sleepDao.insertSleep(sleep)
    }
    fun updateSleep (sleep: Sleep){
        sleepDao.updateSleep(sleep)
    }
    fun getLastSleep():Sleep {
        return sleepDao.getLastSleep()
    }

}