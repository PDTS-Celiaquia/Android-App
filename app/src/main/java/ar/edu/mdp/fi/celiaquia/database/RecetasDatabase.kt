package ar.edu.mdp.fi.celiaquia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.modelo.Receta
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


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
                    // https://android.jlelse.eu/pre-populate-room-database-6920f9acc870
                    val adapterScope = CoroutineScope(Dispatchers.IO)
                    val rdc: Callback = object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            adapterScope.launch {
                                withContext(Dispatchers.IO) {
                                    val dao = getInstance(context).recetasDao
                                    dao.deleteAll()
                                    dao.insertAll(*prepopulateData())
                                }
                            }
                        }
                    }
                    instance = databaseBuilder(
                        context.applicationContext,
                        RecetasDatabase::class.java,
                        "recetas_database"
                    )
                        .addCallback(rdc)
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }

        private fun prepopulateData(): Array<Receta> {
            val list = ArrayList<Receta>()
            list.add(
                Receta(
                    1,
                    R.drawable.canelones_pollo,
                    "Canelones de pollo",
                    "Belleza en forma de comida",
                    4.5F
                )
            )
            list.add(
                Receta(
                    2,
                    R.drawable.crepes_bn,
                    "Crepes",
                    "Bueno, bonito y barato",
                    1F
                )
            )
            list.add(
                Receta(
                    3,
                    R.drawable.empanadillas,
                    "Empanadillas",
                    "Nada como el repulgue de la abuela",
                    4.5F
                )
            )
            list.add(
                Receta(
                    4,
                    R.drawable.ensalada_palta,
                    "Ensalada de palta",
                    "Excelente para comer algo rico y al paso",
                    2.5F
                )
            )
            list.add(
                Receta(
                    5,
                    R.drawable.masa_pizza_sin_gluten,
                    "Masa de pizza sin gluten",
                    "Ideal para sentir que podes comer tacc",
                    4.5F
                )
            )
            list.add(
                Receta(
                    6,
                    R.drawable.pastelchocolate,
                    "Pastel de chocolate",
                    "Para los amantes de lo dulce",
                    5F
                )
            )
            list.add(
                Receta(
                    7,
                    R.drawable.tarta_fresas,
                    "Tarta de fresas",
                    "Rico y calculo que saludable",
                    4F
                )
            )
            list.add(
                Receta(
                    8,
                    R.drawable.salmorejo,
                    "Salmorejo",
                    "No tengo idea qué vas a cocinar pero está rico",
                    4.5F
                )
            )
            return list.toTypedArray()
        }

    }

}