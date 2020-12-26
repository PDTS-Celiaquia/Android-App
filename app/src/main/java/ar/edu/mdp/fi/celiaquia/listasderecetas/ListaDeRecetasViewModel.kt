package ar.edu.mdp.fi.celiaquia.listasderecetas

import android.app.Application
import androidx.lifecycle.ViewModel
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabaseDao
import ar.edu.mdp.fi.celiaquia.modelo.Receta

class ListaDeRecetasViewModel(
    val database: RecetasDatabaseDao,
    val application: Application
) : ViewModel() {

    val list: List<Receta>

    init {
        list = ArrayList<Receta>()
        list.add(
            Receta(
                1,
                R.drawable.canelones_pollo,
                "Canelones de pollo",
                "Belleza en forma de comida",
                4.5F
            )
        )
        list.add(
            Receta(
                2,
                R.drawable.crepes_bn,
                "Crepes",
                "Bueno, bonito y barato",
                1F
            )
        )
        list.add(
            Receta(
                3,
                R.drawable.empanadillas,
                "Empanadillas",
                "Nada como el repulgue de la abuela",
                4.5F
            )
        )
        list.add(
            Receta(
                4,
                R.drawable.ensalada_palta,
                "Ensalada de palta",
                "Excelente para comer algo rico y al paso",
                2.5F
            )
        )
        list.add(
            Receta(
                5,
                R.drawable.masa_pizza_sin_gluten,
                "Masa de pizza sin gluten",
                "Ideal para sentir que podes comer tacc",
                4.5F
            )
        )
        list.add(
            Receta(
                6,
                R.drawable.pastelchocolate,
                "Pastel de chocolate",
                "Para los amantes de lo dulce",
                5F
            )
        )
        list.add(
            Receta(
                7,
                R.drawable.tarta_fresas,
                "Tarta de fresas",
                "Rico y calculo que saludable",
                4F
            )
        )
        list.add(
            Receta(
                8,
                R.drawable.salmorejo,
                "Salmorejo",
                "No tengo idea qué vas a cocinar pero está rico",
                4.5F
            )
        )
    }

}