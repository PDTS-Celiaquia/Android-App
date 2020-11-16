package com.unmdp.celiaquia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_receta.view.*

class MyAdapter(private var lista: List<Receta>, private var context: Context):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder (var vista: View, context: Context): RecyclerView.ViewHolder(vista){
        fun bind(receta: Receta) {
            vista.ivImagen.setImageResource(receta.imagen)
            vista.tvTitulo.setText(receta.nombre)
            vista.tvDescripcion.setText(receta.descripcion)
            vista.rbCalificacion.rating = receta.rate
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent,
            false), context)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }
}
