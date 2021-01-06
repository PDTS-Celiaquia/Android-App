package ar.edu.mdp.fi.celiaquia.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Ingrediente(
    @PrimaryKey
    val idIngrediente: Int,
    val alimento: Alimento,
    val cantidad: Double,
    val unidadDeMedida: UnidadDeMedida
) {
}