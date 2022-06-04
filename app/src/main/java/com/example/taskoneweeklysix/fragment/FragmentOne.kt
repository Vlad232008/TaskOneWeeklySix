package com.example.taskoneweeklysix.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.taskoneweeklysix.databinding.FragmentOneBinding
import java.math.BigDecimal


class FragmentOne : Fragment() {
    private var const = BigDecimal(4)
    private var Counter: Double = 0.0
    private var Counter2: Double = 0.0
    private var result = BigDecimal(3)
    private var show = ""
    private var formula: Double = 0.0
    private var count = 0
    private var count2 = 0
    private var y = BigDecimal(4)
    private var x = 1
    private var z = ""
    private lateinit var binding: FragmentOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneBinding.inflate(inflater, container, false)
        val runnable = Runnable {
            Thread {
                while (true) {
                    Counter += 1
                    if (Counter % 2 == 1.0) {
                        formula = Counter * 2 * (Counter * 2 + 1) * (Counter * 2 + 2)
                        result += (const.divide(BigDecimal(formula), 500, 0))
                        show = result.toString()
                    } else {
                        formula = Counter * 2 * (Counter * 2 + 1) * (Counter * 2 + 2)
                        result -= (const.divide(BigDecimal(formula), 500, 0))
                        show = result.toString()
                    }
                    if (Counter % 1000 == 0.0) {
                        val msg = handler.obtainMessage()
                        msg.obj = show
                        handler.sendMessage(msg)
                    }
                    count++
                }
            }.start()
        }
        val runnable2 = Runnable {
            Thread {
                while (true) {
                    Counter2 += 1
                    if (count2%2 ==0) {
                        y -= (BigDecimal(4).divide(BigDecimal(x+2),500,0))
                        z = y.toString()
                    } else {
                        y += (BigDecimal(4).divide(BigDecimal(x+2),500,0))
                        z = y.toString()
                    }
                    x += 2
                    if (Counter2 % 1000 == 0.0) {
                        val msg1 = handler1.obtainMessage()
                        msg1.obj = z
                        handler1.sendMessage(msg1)
                    }
                    count2++
                }
            }.start()
        }
        val thread2 = Thread(runnable2)
        thread2.start()
        val thread = Thread(runnable)
        thread.start()
        return binding.root
    }

    private var handler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            binding.tvOne.text = msg.obj.toString()
        }
    }
    private var handler1: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg1: Message) {
            binding.tvTwo.text = msg1.obj.toString()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentOne()
    }
}