package com.pangper.infopangulahpermai.model.dkm

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class QurbanModel(
    val name: String? = "",
    val nominal: String? = "",
    val date: String? = "",
    val picture: Int? = null,
    val pengQurban: String? = "",
    val jenisQurban: String? = ""
): Parcelable