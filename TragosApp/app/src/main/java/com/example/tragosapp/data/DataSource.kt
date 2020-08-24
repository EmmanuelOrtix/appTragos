package com.example.tragosapp.data

import com.example.tragosapp.data.model.Drink
import com.example.tragosapp.vo.Resource
import com.example.tragosapp.vo.RetrofitClient

/*
* cla que hace peticion al webservices
*/

class DataSource {

    suspend fun getTragoByName(tragoName:String): Resource<List<Drink>>{
        return Resource.Success(RetrofitClient.webService.getTragoByName(tragoName).drinkList)
    }

}
