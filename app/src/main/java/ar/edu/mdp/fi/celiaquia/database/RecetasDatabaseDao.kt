package ar.edu.mdp.fi.celiaquia.database

import androidx.lifecycle.LiveData
import androidx.room.*
import ar.edu.mdp.fi.celiaquia.modelo.Receta

@Dao
interface RecetasDatabaseDao {
    @Query("SELECT * FROM receta")
    fun getRecetas(): LiveData<List<Receta>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg recetas: Receta)

    @Delete
    fun delete(receta: Receta)
}