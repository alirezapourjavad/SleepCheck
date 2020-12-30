package com.example.sleepcheck.fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.sleepcheck.R
import com.example.sleepcheck.dataModel.Sleep
import com.example.sleepcheck.dataModel.formatDate
import com.example.sleepcheck.dataModel.formatTime
import com.example.sleepcheck.databinding.RecycleHomeBinding

class SleepAdapter  (
    var sleepList :List<Sleep> , private val context: Context
        ) :RecyclerView.Adapter<SleepAdapter.SleepViewHolder>() {

    class SleepViewHolder (val binding: RecycleHomeBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SleepViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecycleHomeBinding.inflate(inflater,parent,false)
        return SleepViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SleepViewHolder, position: Int) {
        val item = sleepList[position]
        holder.binding.tvStartTime.text = item.startTime.formatDate()
        holder.binding.tvEndTime.text = item.endTime.formatDate()
        when(item.type){
            1 -> holder.binding.imgRecycle.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.happyemo))
            2 -> holder.binding.imgRecycle.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.normalemo))
            3 -> holder.binding.imgRecycle.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.angryemo))
        }
        var duration = item.endTime?.minus(item.startTime!!)
        if (duration != null) {
            holder.binding.tvDuration.text = duration.formatTime()
        }

    }

    override fun getItemCount(): Int {
        return sleepList.size
    }
}