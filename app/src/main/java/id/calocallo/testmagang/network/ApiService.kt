package id.calocallo.testmagang.network

import id.calocallo.testmagang.model.ResponsePhotoBatu
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("Gallery_Malang_Batu.json")
    fun batu(): Call<ArrayList<ResponsePhotoBatu>>
}