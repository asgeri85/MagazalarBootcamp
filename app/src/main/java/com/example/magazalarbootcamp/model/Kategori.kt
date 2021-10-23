package com.example.magazalarbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Kategori(

    @field:SerializedName("kategori_id")
    @Expose
    val kategoriId: String,

    @field:SerializedName("kategori_ad")
    @Expose
    val kategoriAd: String
):Parcelable