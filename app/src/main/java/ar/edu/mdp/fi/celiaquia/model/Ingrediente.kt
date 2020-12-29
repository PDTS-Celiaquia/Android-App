package ar.edu.mdp.fi.celiaquia.model

import androidx.room.Entity

@Entity
class Ingrediente(
    val alimento: Alimento,
    val cantidad: Double,
    val unidadDeMedida: String
) {
}