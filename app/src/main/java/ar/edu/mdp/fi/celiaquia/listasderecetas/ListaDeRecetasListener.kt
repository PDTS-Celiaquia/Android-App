package ar.edu.mdp.fi.celiaquia.listasderecetas

import ar.edu.mdp.fi.celiaquia.modelo.Receta

class ListaDeRecetasListener(val clickListener: (recetaId: Long) -> Unit) {
    fun onClick(receta: Receta) = clickListener(receta.uid)
}
