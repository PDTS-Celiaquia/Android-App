package ar.edu.mdp.fi.celiaquia.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ar.edu.mdp.fi.celiaquia.model.Receta

@Dao
interface RecetasDatabaseDao {
    @Query("SELECT * FROM receta")
    fun getAllRecetas(): LiveData<List<Receta>>

    @Query("SELECT * FROM receta WHERE recetaId = :recetaId")
    fun getReceta(recetaId: Long): LiveData<Receta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg recetas: Receta)

    @Delete
    fun delete(receta: Receta)

    @Query("DELETE FROM receta")
    fun deleteAll()
}