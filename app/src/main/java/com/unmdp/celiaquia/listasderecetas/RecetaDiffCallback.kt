package com.unmdp.celiaquia.listasderecetas

import androidx.recyclerview.widget.DiffUtil
import com.unmdp.celiaquia.modelo.Receta

class RecetaDiffCallback :  DiffUtil.ItemCallback<Receta>() {
        override fun areItemsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem.descripcion == newItem.descripcion
        }

        override fun areContentsTheSame(oldItem: Receta, newItem: Receta): Boolean {
            return oldItem == newItem
        }

}