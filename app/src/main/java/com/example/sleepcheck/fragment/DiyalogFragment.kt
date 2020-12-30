package com.example.sleepcheck.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.sleepcheck.R
import com.example.sleepcheck.dataModel.DbRepository
import com.example.sleepcheck.dataModel.SleepDao
import com.example.sleepcheck.dataModel.SleepDb
import com.example.sleepcheck.databinding.FragmentDiyalogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class DiyalogFragment : BottomSheetDialogFragment() {
    lateinit var sleepDao: SleepDao
    lateinit var binding: FragmentDiyalogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDiyalogBinding.inflate(inflater)
        return inflater.inflate(R.layout.fragment_diyalog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sleepDao = SleepDb.getSleepDb(requireContext()).getSleepDao()
        val sleep = sleepDao.getLastSleep()

        binding.imgHappy.setOnClickListener {
            sleep.type = 1
            findNavController().navigateUp()
        }
        binding.imgNormal.setOnClickListener {
            sleep.type = 2
            findNavController().navigateUp()
        }
        binding.imgSad.setOnClickListener {
            sleep.type = 3
            findNavController().navigateUp()
        }

    }

}