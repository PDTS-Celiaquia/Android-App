package com.unmdp.celiaquia.listasderecetas

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.unmdp.celiaquia.R
import com.unmdp.celiaquia.databinding.ItemRecetaBinding
import com.unmdp.celiaquia.modelo.Receta
import kotlinx.android.synthetic.main.item_receta.view.*
import java.lang.ClassCastException

class ListaDeRecetasAdapter :
    ListAdapter<Receta, RecyclerView.ViewHolder>(RecetaDiffCallback()) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val receta = getItem(position) as Receta
                holder.bind(receta)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder(private var binding: ItemRecetaBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(receta: Receta) {
            binding.ivImagen.setImageResource(receta.imagen)
            binding.tvTitulo.setText(receta.nombre)
            binding.tvDescripcion.setText(receta.descripcion)
            binding.rbCalificacion.rating = receta.rate
        }
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemRecetaBinding.inflate(
                    layoutInflater, parent, false
                )
                return ViewHolder(binding)
            }
        }
    }
}