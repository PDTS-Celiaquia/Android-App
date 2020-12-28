package ar.edu.mdp.fi.celiaquia.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Receta (
    @PrimaryKey val uid: Long,
    val imagen: Int,
    val nombre: String,
    val descripcion: String,
    val rating: Float,
//    val ingredientes: Set<Ingrediente>
): Serializable{
}