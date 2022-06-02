package com.example.taskoneweeklysix.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskoneweeklysix.databinding.FragmentOneBinding
import com.example.taskoneweeklysix.manager.BaseFragment
import java.math.BigDecimal


class FragmentOne : BaseFragment() {
    private var const:Double = 4.0
    private var x:Int = 1
    private var count: Long = 0
    private var y = BigDecimal(4)
    private var z = ""
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
                if (count % 2 == 0.toLong()) {
                    y -= BigDecimal(const).divide(BigDecimal(x+2),300,3)
                    z = y.toString()
                    x += 2
                } else {
                    y += BigDecimal(const).divide(BigDecimal(x+2),300,3)
                    z = y.toString()
                    x += 2
                }
                if (x % 100000 == 1) {
                    binding.tvOne.text = z.substring(0,300)
                }
                count++
            }
        }.start()
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}