package com.gregor.playground.model

import android.provider.BaseColumns
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

abstract class BaseModel(
    @ColumnInfo(name = BaseColumns._ID)
    @PrimaryKey(autoGenerate = true) val id: Long?
) {
    constructor() : this(null)
}