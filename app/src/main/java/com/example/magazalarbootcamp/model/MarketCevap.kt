package com.example.magazalarbootcamp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MarketCevap(
    @SerializedName("magazalar")
    @Expose
    var magazalar:List<Market>,
    @SerializedName("success")
    @Expose
    var success:Int
)