package com.example.taskoneweeklysix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskoneweeklysix.fragment.FragmentOne
import com.example.taskoneweeklysix.fragment.FragmentTwo
import com.example.taskoneweeklysix.manager.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FragmentManager.setFragmentOne(FragmentOne.newInstance(), this)
        FragmentManager.setFragmentTwo(FragmentTwo.newInstance(), this)
    }
}