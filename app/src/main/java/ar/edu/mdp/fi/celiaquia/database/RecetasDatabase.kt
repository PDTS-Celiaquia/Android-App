package ar.edu.mdp.fi.celiaquia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import ar.edu.mdp.fi.celiaquia.modelo.Receta

@Database(entities = [Receta::class], version = 1, exportSchema = false)
abstract class RecetasDatabase : RoomDatabase() {

    abstract val recetasDao: RecetasDatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: RecetasDatabase? = null

        fun getInstance(context: Context): RecetasDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = databaseBuilder(
                        context.applicationContext,
                        RecetasDatabase::class.java,
                        "recetas_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }

    }

}