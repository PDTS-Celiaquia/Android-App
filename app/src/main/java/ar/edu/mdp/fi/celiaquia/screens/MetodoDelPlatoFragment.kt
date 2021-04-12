package ar.edu.mdp.fi.celiaquia.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.edu.mdp.fi.celiaquia.MainActivity
import ar.edu.mdp.fi.celiaquia.R


class MetodoDelPlatoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).supportActionBar?.title = getString(R.string.arm_tu_plato)
        return inflater.inflate(R.layout.fragment_metodo_del_plato, container, false)
    }

}