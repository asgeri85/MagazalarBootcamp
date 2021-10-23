package com.example.magazalarbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Market(

	@field:SerializedName("magaza_id")
	@Expose
	val magazaId: String,

	@field:SerializedName("magaza_adres")
	@Expose
	val magazaAdres: String,

	@field:SerializedName("magaza_tel")
	@Expose
	val magazaTel: String,

	@field:SerializedName("kategori")
	@Expose
	val kategori: Kategori,

	@field:SerializedName("magaza_ad")
	@Expose
	val magazaAd: String,

	@field:SerializedName("magaza_resim_ad")
	@Expose
	val magazaResimAd: String
):Parcelable

