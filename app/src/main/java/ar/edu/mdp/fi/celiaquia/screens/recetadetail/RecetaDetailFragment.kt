package ar.edu.mdp.fi.celiaquia.screens.recetadetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.databinding.FragmentRecetaDetailBinding

class RecetaDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentRecetaDetailBinding = FragmentRecetaDetailBinding.inflate(
            inflater, container, false
        )

        val application = requireNotNull(this.activity).application
        val arguments = RecetaDetailFragmentArgs.fromBundle(requireArguments())

        val database = RecetasDatabase.getInstance(application)
        val viewModelFactory = RecetaDetailViewModelFactory(
            arguments.recetaId,
            database,
            application
        )

        val viewModel: RecetaDetailViewModel = ViewModelProvider(this, viewModelFactory)
            .get(RecetaDetailViewModel::class.java)

        binding.receta = viewModel.receta.value

        viewModel.receta.observe(viewLifecycleOwner, {
            it?.let { binding.receta = it }
        })

        binding.lifecycleOwner = this

        return binding.root
    }

}