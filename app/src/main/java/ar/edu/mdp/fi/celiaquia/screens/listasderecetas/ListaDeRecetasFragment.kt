package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.mdp.fi.celiaquia.MainActivity
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.databinding.FragmentListaDeRecetasBinding


class ListaDeRecetasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentListaDeRecetasBinding = FragmentListaDeRecetasBinding
            .inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val database = RecetasDatabase.getInstance(application)
        val viewModelFactory = ListaDeRecetasViewModelFactory(database, application)
        val viewModel: ListaDeRecetasViewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListaDeRecetasViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = ListaDeRecetasAdapter(ListaDeRecetasListener { idReceta ->
            viewModel.onRecetaClicked(idReceta)
        })

        adapter.submitList(viewModel.list.value)

        binding.recetasList.adapter = adapter

        val manager = LinearLayoutManager(context)
        binding.recetasList.layoutManager = manager

        viewModel.list.observe(viewLifecycleOwner, {
            it?.let { adapter.submitList(it) }
        })

        viewModel.navigateToRecetaDetail.observe(viewLifecycleOwner, {
            it?.let {
                this.findNavController().navigate(ListaDeRecetasFragmentDirections
                    .actionListaDeRecetasFragmentToRecetaFragment(it))
                viewModel.onRecetaDetailNavigated()
            }
        })
        (activity as MainActivity).supportActionBar?.title = getString(R.string.recetas)
        return binding.root
    }
}
