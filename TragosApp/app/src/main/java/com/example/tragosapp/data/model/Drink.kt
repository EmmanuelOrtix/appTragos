package com.example.tragosapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
/*
* clase modelo donde se serializa los datos del json
*/
@Parcelize
data class Drink(
    @SerializedName("strDrinkThumb")
    val imagen: String = "",
    @SerializedName("strDrink")
    val nombre: String = "",
    @SerializedName("strInstructions")
    val descripcion: String = "",
    @SerializedName("strAlcoholic")
    val hasAlcohol:String = "Non_Alcoholic"
) : Parcelable

data class DrinkList(
    @SerializedName("drinks")
    val drinkList: List<Drink>
)