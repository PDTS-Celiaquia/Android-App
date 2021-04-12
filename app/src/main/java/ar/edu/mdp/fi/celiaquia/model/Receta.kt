package ar.edu.mdp.fi.celiaquia.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Receta(
    // ajeno al dominio, existe para generar persistencia
    @PrimaryKey
    val idReceta: Int,
    val nombre: String,
    val descripcion: String,
//    val ingredientes: Set<Ingrediente>,
    val instrucciones: String,
    val imagenURL: String,
    val rating: Float,
) : Serializable {}