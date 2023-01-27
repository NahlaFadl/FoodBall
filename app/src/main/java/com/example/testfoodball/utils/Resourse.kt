package com.example.testfoodball.utils

data class Resourse<out T>(val status: Status, val data:T?, val message:String? ){

    companion object{
        fun <T>success(data:T?):Resourse<T>{
            return Resourse(Status.SUCCESS, data,null)
        }

        fun <T> error(msg:String, data:T?):Resourse<T>{
            return Resourse(Status.ERROR,data,msg)
        }

        fun <T> loading(data: T?): Resourse<T> {
            return Resourse(Status.LOADING, data, null)
        }
    }
}
