package com.example.taskoneweeklysix.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskoneweeklysix.databinding.FragmentOneBinding
import com.example.taskoneweeklysix.manager.BaseFragment
import java.math.BigDecimal


class FragmentOne : BaseFragment() {
    private var const = BigDecimal(4)
    private var x:Double = 0.0
    private var y = BigDecimal(3)
    private var z = ""
    private var v:Double = 0.0
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
        Thread{
            while (true) {
                x += 1
                if (x%2 == 1.0) {
                    y += (const.divide(BigDecimal(x*2*(x*2+1)*(x*2+2)),300,0))
                    z = y.toString()
                } else {
                    v = x*2*(x*2+1)*(x*2+2)
                    y -= (const.divide(BigDecimal(x*2*(x*2+1)*(x*2+2)),300,0))
                    z = y.toString()
                }
                if (x % 10000 == 0.0) {
                    binding.tvOne.text = z
                }
            }
        }.start()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}