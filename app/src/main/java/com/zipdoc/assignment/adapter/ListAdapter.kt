package com.zipdoc.assignment.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.zipdoc.assignment.R
import com.zipdoc.assignment.data.ImageData
import com.zipdoc.assignment.databinding.ListItemBinding
import com.zipdoc.assignment.view.MainActivity

class ListAdapter(private val context: Context) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var datas = mutableListOf<ImageData>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)

    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    inner class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ImageData) {
            Glide.with(itemView)
                .load(item.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)

            binding.imageView.setOnClickListener {

                var pos = adapterPosition

                Intent(context, MainActivity::class.java).apply {
                    putExtra("position", pos)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.run { context.startActivity(this) }
            }

        }
    }
}
