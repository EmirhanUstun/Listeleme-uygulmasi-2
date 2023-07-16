package com.emirhan.fifaworldcupwinners.List

import com.google.gson.annotations.SerializedName

data class FutbolcuModel(
    @SerializedName("AdiSoyadi")
    val adiSoyadi: String?,
    @SerializedName("Aciklama")
    val aciklama: String?,
    @SerializedName("ResimURL")
    val resimURL: String?

)