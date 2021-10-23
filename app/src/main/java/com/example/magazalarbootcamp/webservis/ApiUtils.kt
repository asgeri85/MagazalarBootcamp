package com.example.magazalarbootcamp.webservis

class ApiUtils {
    companion object{
        const val BASE_URL="http://kasimadalan.pe.hu/magazalar/"
        fun getDao():MagazaDao{
            return RetrofitClient.getRetrofit(BASE_URL).create(MagazaDao::class.java)
        }
    }
}