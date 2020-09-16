package com.apolis.wenzhao.interviewmock.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.apolis.wenzhao.interviewmock.databinding.RowAdapterRecyclerViewBinding
import com.apolis.wenzhao.interviewmock.model.EpisodeData
import com.apolis.wenzhao.interviewmock.model.EpisodeResponse

class AdapterRecyclerView(private val context: Context) : RecyclerView.Adapter<AdapterRecyclerView.MyViewHolder>() {

    private val listItems = ArrayList<EpisodeData>()

    inner class MyViewHolder(private val binding: RowAdapterRecyclerViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: EpisodeData){
            binding.item = item
            binding.adapter = this@AdapterRecyclerView
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = RowAdapterRecyclerViewBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    fun setData(list: List<EpisodeData>){
        listItems.clear()
        listItems.addAll(list)
        notifyDataSetChanged()
    }

    //Handle item click event
    fun onItemClicked(item: EpisodeData){
        Toast.makeText(context, "${item.id}", Toast.LENGTH_LONG).show()
        //To be implemented： Intent to DetailsActivity
    }
}