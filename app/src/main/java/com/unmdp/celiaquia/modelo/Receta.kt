package com.unmdp.celiaquia.modelo

import com.unmdp.celiaquia.modelo.Ingrediente
import java.io.Serializable

data class Receta (
    val imagen: Int,
    val nombre: String,
    val descripcion: String,
    val rate: Float,
    val ingredientes: Set<Ingrediente>
): Serializable{
}