package com.example.tragosapp.UI

import android.content.Context
import android.gesture.GestureLibraries
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tragosapp.base.BaseViewHolder
import com.example.tragosapp.data.model.Drink
import android.view.View
import android.widget.AdapterView
import com.bumptech.glide.Glide
import com.example.tragosapp.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.tragos_row.view.*

class MainAdapter(
    private val context: Context,
    private val tragosList: List<Drink>,
    private val itemClickListener: OnTragoClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener{
        fun onTragoClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun getItemCount(): Int = tragosList.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
            else -> throw IllegalAccessException("se olvido pasar el viewHolder en el bind")
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_trago)
            itemView.txt_nombre.text = item.nombre
            itemView.txt_descripcion.text = item.descripcion
            itemView.setOnClickListener { itemClickListener.onTragoClick(item) }
        }

    }
}