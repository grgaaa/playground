package com.gregor.playground.model

import androidx.room.Entity
import androidx.room.Index

@Entity(indices = [Index(value = ["label", "description"], unique = true)])
data class Poi(
    val poiId: Long?,
    val label: String,
    val description: String?,
    val keywords: String,
    val latitude: String,
    val longitude: String
) : BaseModel()
