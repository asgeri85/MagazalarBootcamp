package com.example.magazalarbootcamp.model

import android.content.LocusId
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BrosurCevap(
    @SerializedName("brosurler")
    @Expose
    var brosurler:List<Brosur>,

    @SerializedName("success")
    @Expose
    var success:Int
)