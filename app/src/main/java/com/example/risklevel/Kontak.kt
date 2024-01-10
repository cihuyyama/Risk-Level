package com.example.risklevel

import com.google.gson.annotations.SerializedName

data class Kontak (
    val id: Int,
    val nama: String,
    val notelp: String,
    val email: String

)

data class LoginModel (
    val email: String,
    val password: String
)

data class LoginResponse (
    val token: String
)

data class User(
    @SerializedName("data")
    val user: UserInfo
)
data class UserInfo (
    val username: String,
    val email: String
)

data class KontakList (
    @SerializedName("data")
    val kontaks: List<Kontak>
)