package ar.edu.mdp.fi.celiaquia.recetadetail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase

class RecetaDetailViewModelFactory(
    private val recetaId: Long,
    private val database: RecetasDatabase,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecetaDetailViewModel::class.java)) {
            return RecetaDetailViewModel(recetaId, database, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}