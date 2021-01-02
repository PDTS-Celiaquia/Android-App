package ar.edu.mdp.fi.celiaquia.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Receta(
    // ajeno al dominio, existe para generar persistencia
    @PrimaryKey val recetaId: Long,
    val imagen: Int,
    val nombre: String,
    val descripcion: String,
    val rating: Float,
    val instrucciones: String,
//    val costo: Int // de 0 a 10
) : Serializable {
}