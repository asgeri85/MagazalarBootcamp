package com.example.magazalarbootcamp.webservis


import com.example.magazalarbootcamp.model.BrosurCevap
import com.example.magazalarbootcamp.model.KategoriCevap
import com.example.magazalarbootcamp.model.MarketCevap
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface MagazaDao {
    @GET("tum_kategoriler.php")
    fun tumKategori():retrofit2.Call<KategoriCevap>

    @POST("tum_magazalar_by_kategori_id.php")
    @FormUrlEncoded
    fun magazaGetir(@Field("kategori_id") k_id:Int):Call<MarketCevap>

    @POST("tum_brosurler_by_magaza_id.php")
    @FormUrlEncoded
    fun brosurler(@Field("magaza_id") m_id:Int):Call<BrosurCevap>
}