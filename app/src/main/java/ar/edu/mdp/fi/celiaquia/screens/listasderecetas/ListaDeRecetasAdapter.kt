package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ar.edu.mdp.fi.celiaquia.databinding.ItemRecetaBinding
import ar.edu.mdp.fi.celiaquia.model.Receta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class ListaDeRecetasAdapter(
    private val clickListener: ListaDeRecetasListener
) : ListAdapter<Receta, RecyclerView.ViewHolder>(RecetaDiffCallback()) {

    class ViewHolder(private val binding: ItemRecetaBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(receta: Receta, clickListener: ListaDeRecetasListener) {
            binding.receta = receta
            binding.clickListener = clickListener
            binding.executePendingBindings()
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

    private val adapterScope = CoroutineScope(Dispatchers.Default)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> {
                val receta = getItem(position) as Receta
                holder.bind(receta, clickListener)
            }
        }
    }


}