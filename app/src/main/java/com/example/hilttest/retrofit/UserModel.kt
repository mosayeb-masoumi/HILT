package com.example.hilttest.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class UserModel(

    @SerializedName("userId")
    @Expose
    var userId: Int? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("body")
    @Expose
    var body: String? = null,

//
//var userId: Int? = null,
//var id: Int? = null,
//var title: String? = null,
//
//var body: String? = null

)
