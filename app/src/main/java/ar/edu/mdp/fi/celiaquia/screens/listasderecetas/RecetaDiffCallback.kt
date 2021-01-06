package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import androidx.recyclerview.widget.DiffUtil
import ar.edu.mdp.fi.celiaquia.model.Receta

class RecetaDiffCallback :  DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.idReceta == newItem.idReceta
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }

}