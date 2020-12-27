package ar.edu.mdp.fi.celiaquia.listasderecetas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.databinding.FragmentListaDeRecetasBinding


class ListaDeRecetasFragment : Fragment() {

    private var _binding: FragmentListaDeRecetasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentListaDeRecetasBinding
            .inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = RecetasDatabase.getInstance(application).recetasDao
        val viewModelFactory = ListaDeRecetasViewModelFactory(dataSource, application)
        val viewModel: ListaDeRecetasViewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListaDeRecetasViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        val adapter = ListaDeRecetasAdapter()
        adapter.submitList(viewModel.list)
        binding.recetasList.adapter = adapter

        val manager = LinearLayoutManager(context)
        binding.recetasList.layoutManager = manager

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

@BindingAdapter("android:src")
fun setImageViewResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}
