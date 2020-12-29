package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import ar.edu.mdp.fi.celiaquia.model.Receta

class ListaDeRecetasListener(val clickListener: (recetaId: Long) -> Unit) {
    fun onClick(receta: Receta) = clickListener(receta.recetaId)
}
