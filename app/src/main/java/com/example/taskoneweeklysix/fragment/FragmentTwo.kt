package com.example.taskoneweeklysix.fragment

import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskoneweeklysix.databinding.FragmentTwoBinding
import com.example.taskoneweeklysix.manager.BaseFragment

class FragmentTwo : BaseFragment() {
    private lateinit var binding: FragmentTwoBinding
    override fun onClickNew() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTwoBinding.inflate(inflater, container, false)
        binding.cMeter.start()
        binding.btnPlay.setOnClickListener {
            binding.cMeter.start()
        }
        binding.btnPause.setOnClickListener {
            binding.cMeter.stop()
        }
        binding.btnReset.setOnClickListener {
            binding.cMeter.base = SystemClock.elapsedRealtime()
            binding.cMeter.start()
        }
        //binding.cMeter.text = ""
        return binding.root
    }
    companion object {
        @JvmStatic
        fun newInstance() = FragmentTwo()
    }
}