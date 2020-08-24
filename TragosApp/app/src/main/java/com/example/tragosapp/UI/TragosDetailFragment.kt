package com.example.tragosapp.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.tragosapp.R
import com.example.tragosapp.data.model.Drink
import kotlinx.android.synthetic.main.fragment_tragos_detail.*
import kotlin.math.log

class TragosDetailFragment : Fragment() {

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireArguments().let {
            drink = it.getParcelable("drink")!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tragos_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(requireContext()).load(drink.imagen).centerCrop().into(img_trago_detalle)
        txt_trago_titulo.text = drink.nombre
        txt_trago_descripcion.text = drink.descripcion
        if(drink.hasAlcohol.equals("Non_Alcoholic"))
        {
            txt_has_alcohol.visibility = View.GONE
        }
        else {
            txt_has_alcohol.text = drink.hasAlcohol
        }
    }

}