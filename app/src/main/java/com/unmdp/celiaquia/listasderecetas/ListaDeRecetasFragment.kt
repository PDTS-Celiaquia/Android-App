package com.unmdp.celiaquia.listasderecetas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.unmdp.celiaquia.R
import com.unmdp.celiaquia.modelo.RVRecetasAdapter
import com.unmdp.celiaquia.modelo.Receta
import java.util.ArrayList


class ListaDeRecetasFragment : Fragment() {
    private lateinit var rvRecetas: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var vista: View = inflater.inflate(R.layout.fragment_lista_de_recetas, container, false)
        rvRecetas = vista.findViewById<RecyclerView>(R.id.rvRecetas)
        rvRecetas.layoutManager = LinearLayoutManager(context)
        rvRecetas.adapter = context?.let {
            RVRecetasAdapter(
                getRecetas(),
                it
            )
        }
        return vista
    }

    private fun getRecetas(): ArrayList<Receta> { //deberia solicitar los datos a un web service
        val list = ArrayList<Receta>()
        list.add(
            Receta(
                R.drawable.canelones_pollo,
                "Canelones de pollo",
                "Belleza en forma de comida",
                4.5F
            )
        )
        list.add(
            Receta(
                R.drawable.crepes_bn,
                "Crepes",
                "Bueno, bonito y barato",
                1F
            )
        )
        list.add(
            Receta(
                R.drawable.empanadillas,
                "Empanadillas",
                "Nada como el repulgue de la abuela",
                4.5F
            )
        )
        list.add(
            Receta(
                R.drawable.ensalada_palta,
                "Ensalada de palta",
                "Excelente para comer algo rico y al paso",
                2.5F
            )
        )
        list.add(
            Receta(
                R.drawable.masa_pizza_sin_gluten,
                "Masa de pizza sin gluten",
                "Ideal para sentir que podes comer tacc",
                4.5F
            )
        )
        list.add(
            Receta(
                R.drawable.pastelchocolate,
                "Pastel de chocolate",
                "Para los amantes de lo dulce",
                5F
            )
        )
        list.add(
            Receta(
                R.drawable.tarta_fresas,
                "Tarta de fresas",
                "Rico y calculo que saludable",
                4F
            )
        )
        list.add(
            Receta(
                R.drawable.salmorejo,
                "Salmorejo",
                "No tengo idea qué vas a cocinar pero está rico",
                4.5F
            )
        )
        return list
    }
}