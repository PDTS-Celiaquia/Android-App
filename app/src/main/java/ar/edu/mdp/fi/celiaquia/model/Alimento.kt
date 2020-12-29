package ar.edu.mdp.fi.celiaquia.model

import androidx.room.Entity

@Entity
class Alimento(
    val nombre: String,
    val clasificacion: String,
    val genero_especie_variedad: String,
    val numero: Int,
    val energia_kcal: Double,
    val agua: Double,
    val proteina: Double,
    val grasa_total: Double,
    val carbohidrato_total: Double,
    val carbohidrato_disponible: Double,
    val fibra_dietetica: Double,
    val ceniza: Double,
    val sodio: Double,
    val calcio: Double,
    val fosforo: Double,
    val hierro: Double,
    val zinc: Double,
    val tiamina: Double,
    val rivoFlavina: Double,
    val niacina: Double,
    val vitamina_c: Double
) {
}