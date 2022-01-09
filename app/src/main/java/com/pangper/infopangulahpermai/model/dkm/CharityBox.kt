package com.pangper.infopangulahpermai.model.dkm

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharityBox(
    val name: String? = "",
    val nominal: String? = "",
    val date: String? = "",
    val picture: Int? = null
): Parcelable