package dev.kibet.e_sports.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.kibet.e_sports.data.model.Sport
import dev.kibet.e_sports.databinding.ActivityMainBinding
import dev.kibet.e_sports.ui.adapters.SportsAdapter
import dev.kibet.e_sports.ui.viewmodel.SportsViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: SportsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        viewModel.sportsResponse.observe(viewLi, Observer {

        })
    }

    private fun recyclerSports(sport: List<Sport>){
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            hasFixedSize()
            adapter = SportsAdapter(sport)
        }
    }

}