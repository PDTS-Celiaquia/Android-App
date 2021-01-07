package ar.edu.mdp.fi.celiaquia.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ar.edu.mdp.fi.celiaquia.MainActivity
import ar.edu.mdp.fi.celiaquia.R

class InfoFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        (activity as MainActivity).supportActionBar?.title = getString(R.string.informacion)
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

}