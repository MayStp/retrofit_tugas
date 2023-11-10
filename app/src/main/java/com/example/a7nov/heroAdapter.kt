package com.example.recycler_view

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a7nov.R
import com.example.a7nov.databinding.ItemSuperheroBinding
import com.example.a7nov.model.HeroData



class heroAdapter(private val listHero: List<HeroData>, ):
    RecyclerView.Adapter<heroAdapter.ItemSuperheroViewHolder>(){
    inner class ItemSuperheroViewHolder (private val binding
    :ItemSuperheroBinding):RecyclerView.ViewHolder(binding.root) {
        val itemImage: ImageView = itemView.findViewById(R.id.img_hero)
        fun bind(data: HeroData) {
            with(binding) {
                title.text = data.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ItemSuperheroViewHolder {
        val binding =
            ItemSuperheroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemSuperheroViewHolder(binding)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ItemSuperheroViewHolder, position: Int) {
        holder.bind(listHero[position])
        Glide.with(holder.itemView.context)
            .load(listHero[position].image)
            .centerCrop()
            .into(holder.itemImage)
    }
}