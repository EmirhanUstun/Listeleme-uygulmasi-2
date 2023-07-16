package com.h5210060_emirhan.ustun_final.List

import com.emirhan.fifaworldcupwinners.List.FutbolcuModel
import retrofit2.http.GET

interface FutbolcuApi {

    @GET("futbolcular.json")
    suspend fun getAlbums(): List<FutbolcuModel?>



}