package com.example.magazalarbootcamp.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class KategoriCevap(

	@field:SerializedName("kategoriler")
	@Expose
	val kategoriler: List<Kategori>,

	@field:SerializedName("success")
	@Expose
	val success: Int
)

