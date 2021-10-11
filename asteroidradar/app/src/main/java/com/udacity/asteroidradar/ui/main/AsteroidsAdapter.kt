package com.udacity.asteroidradar.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.databinding.AsteroidItemBinding
import com.udacity.asteroidradar.domain.Asteroid

class AsteroidsAdapter internal constructor(private val callback: AsteroidClick) :
    ListAdapter<Asteroid, AsteroidsAdapter.AsteroidViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsteroidViewHolder {
        return AsteroidViewHolder(AsteroidItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AsteroidViewHolder, position: Int) {
        val asteroid = getItem(position)
        holder.itemView.setOnClickListener {
            callback.onClick(asteroid)
        }

        // For accessibility purposes
        val contentDescription = "Asteroid $position: ${asteroid.codename} " +
                "${asteroid.closeApproachDate} potentially hazardous: " +
                "${asteroid.isPotentiallyHazardous}"
        holder.itemView.contentDescription = contentDescription
        holder.bind(asteroid)
    }

    inner class AsteroidViewHolder(private val viewDataBinding: AsteroidItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(asteroid: Asteroid) {
            viewDataBinding.asteroid = asteroid
            viewDataBinding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class AsteroidClick(val block: (Asteroid) -> Unit) {
        fun onClick(asteroid: Asteroid) = block(asteroid)
    }
}
