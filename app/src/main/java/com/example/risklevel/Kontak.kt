package com.example.risklevel

import com.google.gson.annotations.SerializedName

data class Kontak (
    val id: Int,
    val nama: String,
    val no_telp: String,
    val email: String

)


data class KontakList (
    @SerializedName("data")
    val kontaks: List<Kontak>
)