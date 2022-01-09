package com.pangper.infopangulahpermai.model.rt

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CitizenDataRT03(
    val name: String?    = "",
    val address: String? = "",
    val gender: String?  = "",
    val status: String?  = "" // Status Warga Tetap atau bukan
): Parcelable