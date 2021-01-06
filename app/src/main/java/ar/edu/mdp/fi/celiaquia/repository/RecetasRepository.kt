package ar.edu.mdp.fi.celiaquia.repository

import androidx.lifecycle.LiveData
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.model.Receta
import ar.edu.mdp.fi.celiaquia.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class RecetasRepository(private val database: RecetasDatabase) {
    private val recetasDao = database.recetasDao

    val recetas: LiveData<List<Receta>> = recetasDao.getAllRecetas()

    fun getReceta(idReceta: Int): LiveData<Receta> {
        return recetasDao.getReceta(idReceta)
    }

    suspend fun refreshRecetas() {
        withContext(Dispatchers.IO) {
            val recetas = Network.recetasService.getRecetasAsync().await()
            recetasDao.insertAll(*recetas.toTypedArray())
        }
    }

}