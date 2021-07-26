package dev.kibet.e_sports.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dev.kibet.e_sports.R
import dev.kibet.e_sports.data.model.Sport
import dev.kibet.e_sports.databinding.ItemListBinding

class SportsAdapter(private val sports: List<Sport>) : RecyclerView.Adapter<SportsAdapter.SportsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SportsViewHolder(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: SportsViewHolder, position: Int): Unit = with(holder.binding) {
        val sport = sports[position]

        val context = holder.itemView.context

        Glide.with(context)
            .load(sport.strSportThumb)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(sportImage)

        sportName.text = sport.strSport
        sportDesc.text = sport.strSportDescription

    }

    override fun getItemCount(): Int = sports.size

    class SportsViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }
}