package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.model.Receta
import ar.edu.mdp.fi.celiaquia.repository.RecetasRepository

class ListaDeRecetasViewModel(
    private val database: RecetasDatabase,
    val application: Application
) : ViewModel() {

    private val repository: RecetasRepository = RecetasRepository(database)
    val list: LiveData<List<Receta>> = repository.recetas

    private val _navigateToRecetaDetail = MutableLiveData<Int>()

    val navigateToRecetaDetail: LiveData<Int>
        get() = _navigateToRecetaDetail

    fun onRecetaClicked(idReceta: Int) {
        _navigateToRecetaDetail.value = idReceta
    }

    fun onRecetaDetailNavigated() {
        _navigateToRecetaDetail.value = null
    }

}