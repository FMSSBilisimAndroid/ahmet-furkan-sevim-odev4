package com.empedocles.marsestate.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.empedocles.marsestate.databinding.FeedItemBinding
import com.empedocles.marsestate.model.Estate
import com.empedocles.marsestate.util.downloadFromUrl
import com.empedocles.marsestate.view.FeedFragment

class EstateAdapter(private val estateList: ArrayList<Estate>)
    : RecyclerView.Adapter<EstateAdapter.ItemHolder>() {

    class ItemHolder(private val binding: FeedItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(estate : Estate){
            binding.itemImg.downloadFromUrl(estate.imageUrl)
            binding.estate = estate
            binding.root.context as? LifecycleOwner
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemBinding = FeedItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(estateList[position])
    }

    override fun getItemCount(): Int {
        return estateList.size
    }

    fun updateEstateList(newEstateList : List<Estate>){
        estateList.clear()
        estateList.addAll(newEstateList)
        notifyDataSetChanged()
    }
}