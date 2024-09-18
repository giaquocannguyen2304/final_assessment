package com.example.finalassessment.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListOfEntities  (
    val entities: List<Entity>,
    val entityTotal: Int
) : Parcelable