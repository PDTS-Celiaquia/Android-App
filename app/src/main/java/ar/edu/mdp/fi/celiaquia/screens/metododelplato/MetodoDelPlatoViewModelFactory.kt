package ar.edu.mdp.fi.celiaquia.screens.metododelplato

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase

class MetodoDelPlatoViewModelFactory(private val database: RecetasDatabase): ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MetodoDelPlatoViewModel::class.java)) {
            return MetodoDelPlatoViewModel(database) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}