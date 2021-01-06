package ar.edu.mdp.fi.celiaquia.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Alimento(
    @PrimaryKey
    val numero: Int,
    val nombre: String,
    val clasificacion: String, // carnes, cereales, etc. Son las diferentes tablas
    val genero_especie_variedad: String, //algunas tablas de alimento lo tienen
    val energia_kJ: Double,
    val agua: Double,
    val proteina: Double,
    val grasa_total: Double,
    val carbohidrato_total: Double,
    val carbohidrato_disponible: Double,
    val fibra_dietetica: Double,
    val ceniza: Double,
    val sodio: Double,
    val potasio: Double,
    val calcio: Double,
    val fosforo: Double,
    val hierro: Double,
    val zinc: Double,
    val tiamina: Double,
    val rivoflavina: Double,
    val niacina: Double,
    val vitamina_c: Double,
    val acidos_grasos_saturados: Double,
    val acidos_grasos_monoinsaturados: Double,
    val acidos_grasos_poliinsaturados: Double,
    val colesterol: Double,
) {}