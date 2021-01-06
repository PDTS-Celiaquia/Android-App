package ar.edu.mdp.fi.celiaquia.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.model.Receta
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
            val instrucciones = "<h3><strong>Ingredientes</strong></h3>\n" +
                    "<ul>\n" +
                    "<li>250 gr de premezcla</li>\n" +
                    "<li>10 gr de levadura seca</li>\n" +
                    "<li>4 gr de azucar</li>\n" +
                    "<li>sal a gusto</li>\n" +
                    "<li>30 cc de aceite</li>\n" +
                    "<li>250cc de agua</li>\n" +
                    "</ul>\n" +
                    "<h3><strong>Instrucciones</strong></h3>\n" +
                    "<p><strong>Paso 1: espumar la levadura</strong></p>\n" +
                    "<p>El primer paso es espumar la levadura. ¿Cómo se hace? Muy fácil. En un recipiente vas a diluir la levadura con un poquito de agua tibia y el azúcar. Una vez que la levadura esté bien disuelta la vas a reservar unos minutitos.</p>\n" +
                    "<p><strong>Paso 2: mezclar ingredientes secos y líquidos</strong></p>\n" +
                    "<p>El segundo paso es mezclar los ingredientes secos. En un recipiente vas a colocar premezcla y sal y vas a mezclar. Una vez que estos ingredientes estén bien integrados, vas a hacer un hueco en el medio y vas a agregar agua, aceite y la levadura espumada.</p>\n" +
                    "<p><strong>Paso 3: armar la masa para pizza sin gluten</strong></p>\n" +
                    "<p>A continuación vas a mezclar bien los ingredientes, primero con un utensilio y, cuando puedas, vas a usar las manos hasta lograr una masa suave pero pegajosa. Es una masa húmeda que se te pegará en los dedos. Cuando tengas la masa lista vas a dejarla leudar por aproximadamente 20 minutos.</p>\n" +
                    "<p><strong>Paso 4: hacer el resto</strong></p>\n" +
                    "<p>Ya para este punto creo que se entendió el formato que se va a seguir con las recetas</p>"
            list.add(
                Receta(
                    1,
                    "Canelones de pollo",
                    "Belleza en forma de comida",
//                    null,
                    instrucciones,
                    R.drawable.canelones_pollo,
                    4.5F,
                )
            )
            list.add(
                Receta(
                    2,
                    "Crepes",
                    "Bueno, bonito y barato",
//                    null,
                    instrucciones,
                    R.drawable.crepes_bn,
                    1F,
                )
            )
            list.add(
                Receta(
                    3,
                    "Empanadillas",
                    "Nada como el repulgue de la abuela",
//                    null,
                    instrucciones,
                    R.drawable.empanadillas,
                    4.5F,
                )
            )
            list.add(
                Receta(
                    4,
                    "Ensalada de palta",
                    "Excelente para comer algo rico y al paso",
//                    null,
                    instrucciones,
                    R.drawable.ensalada_palta,
                    2.5F,
                )
            )
            list.add(
                Receta(
                    5,
                    "Masa de pizza sin gluten",
                    "Ideal para sentir que podes comer tacc",
//                    null,
                    instrucciones,
                    R.drawable.masa_pizza_sin_gluten,
                    4.5F,
                )
            )
            list.add(
                Receta(
                    6,
                    "Pastel de chocolate",
                    "Para los amantes de lo dulce",
//                    null,
                    instrucciones,
                    R.drawable.pastelchocolate,
                    5F,
                )
            )
            list.add(
                Receta(
                    7,
                    "Tarta de fresas",
                    "Rico y calculo que saludable",
//                    null,
                    instrucciones,
                    R.drawable.tarta_fresas,
                    4F,
                )
            )
            list.add(
                Receta(
                    8,
                    "Salmorejo",
                    "No tengo idea qué vas a cocinar pero está rico",
//                    null,
                    instrucciones,
                    R.drawable.salmorejo,
                    4.5F,
                )
            )
            return list.toTypedArray()
        }

    }

}