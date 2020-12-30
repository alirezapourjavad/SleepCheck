 package com.example.sleepcheck.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.sleepcheck.R
import com.example.sleepcheck.dataModel.DbRepository
import com.example.sleepcheck.dataModel.Sleep
import com.example.sleepcheck.dataModel.SleepDao
import com.example.sleepcheck.dataModel.SleepDb
import com.example.sleepcheck.databinding.FragmentHomeBinding
import java.util.*


class HomeFragment : Fragment() {
    lateinit var sleepDao: SleepDao
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sleepDao = SleepDb.getSleepDb(requireContext()).getSleepDao()

        val sleepList = sleepDao.getSleepList()
        val sleepAdapter = SleepAdapter(sleepList,requireContext())
        binding.rvSleepType.adapter=sleepAdapter

        binding.btnStart.setOnClickListener {
            val sleep = Sleep(Date().time,0,0)
            sleepDao.insertSleep(sleep)
            binding.imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.wakeup))

        }
        binding.btnStop.setOnClickListener {
            val endTime = Date().time
            sleepDao.getLastSleep().endTime=endTime

            binding.imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.sleep))

            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDiyalogFragment())

        }




    }

}