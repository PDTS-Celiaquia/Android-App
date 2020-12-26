package ar.edu.mdp.fi.celiaquia.listasderecetas

import androidx.recyclerview.widget.DiffUtil
import ar.edu.mdp.fi.celiaquia.modelo.Receta

class RecetaDiffCallback :  DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }

}