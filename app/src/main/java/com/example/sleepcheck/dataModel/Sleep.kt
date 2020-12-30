package com.example.sleepcheck.dataModel

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "sleep_table")
data class Sleep(
    @ColumnInfo(name = "sleep_startTime")
    var startTime: Long = 0,
    @ColumnInfo(name = "sleep_endTime")
    var endTime: Long = 0,
    @ColumnInfo(name = "sleep_type")
    var type: Int = 0,
    @ColumnInfo(name = "sleep_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
):Parcelable

