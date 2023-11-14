package com.gregor.playground.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gregor.playground.model.Poi
import io.reactivex.rxjava3.core.Flowable

@Dao
interface PoiDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAll(vararg pois: Poi)

    @Query("SELECT * FROM poi")
    fun getAll(): Flowable<List<Poi>>
}