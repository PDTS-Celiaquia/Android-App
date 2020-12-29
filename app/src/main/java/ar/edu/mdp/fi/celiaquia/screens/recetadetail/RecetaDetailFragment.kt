package ar.edu.mdp.fi.celiaquia.screens.recetadetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.edu.mdp.fi.celiaquia.R
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.databinding.FragmentRecetaDetailBinding

class RecetaDetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentRecetaDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_receta_detail, container, false
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

        binding.instruccionesText.text = HtmlCompat.fromHtml(
            "<h2>Title</h2><br><p>Description here ${viewModel.receta.value?.descripcion} </p>",
            HtmlCompat.FROM_HTML_MODE_COMPACT
        )

        binding.lifecycleOwner = this

        return binding.root
    }

}