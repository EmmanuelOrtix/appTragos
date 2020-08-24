package com.example.tragosapp.base

import androidx.recyclerview.widget.RecyclerView
import android.view.View

/*
 * clase generica para pasar los datos
 */

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){
    abstract fun bind(item: T, position:Int)
}