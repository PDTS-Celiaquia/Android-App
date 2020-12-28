package ar.edu.mdp.fi.celiaquia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ar.edu.mdp.fi.celiaquia.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupNavigation()
    }

    private fun setupNavigation() {
        setSupportActionBar(binding.toolbar)
    }

}