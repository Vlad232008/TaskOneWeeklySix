package com.example.taskoneweeklysix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskoneweeklysix.fragment.FragmentOne
import com.example.taskoneweeklysix.fragment.FragmentTwo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frOne, FragmentOne.newInstance())
        transaction.commit()
        val transaction1 = this.supportFragmentManager.beginTransaction()
        transaction1.replace(R.id.frTwo, FragmentTwo.newInstance())
        transaction1.commit()
    }
}