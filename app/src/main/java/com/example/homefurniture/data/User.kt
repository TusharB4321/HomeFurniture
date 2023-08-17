package com.example.homefurniture.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


data class User(
    var firstName:String,
    var lastName:String,
    var email:String,
    var imagePath:String=""
){

    constructor() : this("","","")
}

