package com.pangper.infopangulahpermai.model.dkm

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ElectricModel(
    val pengurus: String? = "",
    val nominal: String? = "",
    val date: String? = "",
    val picture: Int? = null,
    val status: String? = "",
    val keterangan: String? = "",
    val pendonasi: String? = ""
): Parcelable