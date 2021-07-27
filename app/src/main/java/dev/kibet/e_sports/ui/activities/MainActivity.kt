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
import dev.kibet.e_sports.util.Resource
import dev.kibet.e_sports.util.Status
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: SportsViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        subscribeToObservers()

        viewModel.fetchSports()
    }

    private fun subscribeToObservers() {
        viewModel.sportsResponse.observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        lifecycleScope.launch {
                           // it.data?.let { it1 -> recyclerSports(it1.sports) }
                            recyclerSports(it.data!!.sports)
                        }
                    }
                }
            }

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