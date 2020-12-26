package ar.edu.mdp.fi.celiaquia.listasderecetas

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabaseDao

class ListaDeRecetasViewModelFactory(
    private val dataSource: RecetasDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListaDeRecetasViewModel::class.java)) {
            return ListaDeRecetasViewModel(dataSource, application) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}