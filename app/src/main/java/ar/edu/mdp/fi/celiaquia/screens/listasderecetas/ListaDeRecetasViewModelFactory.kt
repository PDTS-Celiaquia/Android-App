package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase

class ListaDeRecetasViewModelFactory(
    private val database: RecetasDatabase,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListaDeRecetasViewModel::class.java)) {
            return ListaDeRecetasViewModel(database, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}