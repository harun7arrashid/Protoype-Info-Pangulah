package com.pangper.infopangulahpermai.model.rt

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MoneyRt03(
    val name: String?  = "", // Nama Penginput
    val total: String? = "",
    val desc: String?  = "",
    val date: String?  = "",
    val picture: Int?  = null,
    val status: String? = ""
): Parcelable