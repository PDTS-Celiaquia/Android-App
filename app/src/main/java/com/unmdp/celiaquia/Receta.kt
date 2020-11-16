package com.unmdp.celiaquia

import java.io.Serializable

data class Receta (
    val imagen: Int,
    val nombre: String,
    val descripcion: String,
    val rate: Float
): Serializable{
}