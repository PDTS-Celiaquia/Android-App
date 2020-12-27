package ar.edu.mdp.fi.celiaquia.listasderecetas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.databinding.ItemRecetaBinding
import ar.edu.mdp.fi.celiaquia.modelo.Receta

class ListaDeRecetasAdapter :
    ListAdapter<Receta, RecyclerView.ViewHolder>(RecetaDiffCallback()) {

    class ViewHolder(val binding: ItemRecetaBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(receta: Receta) {
            binding.receta = receta
            binding.fotoImage.setImageResource(receta.imagen)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val receta = getItem(position) as Receta
                holder.bind(receta)
            }
        }
    }


}