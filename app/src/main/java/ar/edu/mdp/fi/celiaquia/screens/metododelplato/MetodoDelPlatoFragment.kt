package ar.edu.mdp.fi.celiaquia.screens.metododelplato

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.MainActivity
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.screens.recetadetail.RecetaDetailViewModel
import ar.edu.mdp.fi.celiaquia.screens.recetadetail.RecetaDetailViewModelFactory


class MetodoDelPlatoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).supportActionBar?.title = getString(R.string.arm_tu_plato)

        val application = requireNotNull(this.activity).application
        val database = RecetasDatabase.getInstance(application)
        val viewModelFactory = MetodoDelPlatoViewModelFactory(
            database
        )

        val viewModel: MetodoDelPlatoViewModel = ViewModelProvider(this, viewModelFactory)
            .get(MetodoDelPlatoViewModel::class.java)

        return inflater.inflate(R.layout.fragment_metodo_del_plato, container, false)
    }

}