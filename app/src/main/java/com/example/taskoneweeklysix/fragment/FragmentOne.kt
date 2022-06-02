package com.example.taskoneweeklysix.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskoneweeklysix.databinding.FragmentOneBinding
import com.example.taskoneweeklysix.manager.BaseFragment
import java.text.DecimalFormat


class FragmentOne : BaseFragment() {
    private var const:Double = 4.0
    private var x:Int = 1
    private var count: Long = 0
    private var y: Double = 4.0
    private lateinit var binding: FragmentOneBinding
    override fun onClickNew() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        val decimalFormat = DecimalFormat("#.###########################################################")
        Thread{
            while (true) {
                if (count%2 == 0.toLong()) {
                    y -= const / (x + 2)
                    x += 2
                } else {
                    y += const / (x + 2)
                    x += 2
                }
                if (x%10000000 == 1) {
                    val result = decimalFormat.format(y)
                    binding.tvOne.text = result.toString()
                }
                count++
                Log.d("MyLog", count.toString())
            }
        }.start()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}