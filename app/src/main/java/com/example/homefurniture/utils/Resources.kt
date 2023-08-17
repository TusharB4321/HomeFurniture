package com.example.homefurniture.utils

//Ye ek gereric class hai means ye har ek type ke data class receive kr skta hai
sealed class Resources<T>(
    val data:T?=null,
    val message:String?=null
){
    class Success<T>(data: T):Resources<T>(data)
    class Error<T>(message: String):Resources<T>(message=message)
    class Loading<T>:Resources<T>()
}
