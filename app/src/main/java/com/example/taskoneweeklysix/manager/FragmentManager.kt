package com.example.taskoneweeklysix.manager

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taskoneweeklysix.R

object FragmentManager {
    private var currentFragOne: Fragment? = null
    private var currentFraqTwo: Fragment? = null

    fun setFragmentOne(newFrag: Fragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frOne, newFrag)
        transaction.commit()
        currentFragOne = newFrag
    }
    fun setFragmentTwo(newFrag: Fragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frTwo, newFrag)
        transaction.commit()
        currentFraqTwo = newFrag
    }
}