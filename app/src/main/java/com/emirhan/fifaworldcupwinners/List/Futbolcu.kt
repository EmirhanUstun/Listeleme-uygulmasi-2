package com.h5210060_emirhan.ustun_final.List

data class Futbolcu(
    val isim: String,
    val aciklama: String,
    val resimUrl: String,
    val detay: String
) : Comparable<Futbolcu> {
    override fun compareTo(other: Futbolcu): Int {
        return isim.compareTo(other.isim)
    }

}

