package com.example.magazalarbootcamp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Brosur(
    @SerializedName("brosur_id")
    @Expose
    var brosur_id:Int,
    @SerializedName("brosur_resim_ad")
    @Expose
    var brosur_resim_ad:String,
    @SerializedName("magaza_id")
    @Expose
    var magaza_id:Int
)