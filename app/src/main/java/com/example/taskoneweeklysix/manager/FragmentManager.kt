package com.example.taskoneweeklysix.manager

import androidx.appcompat.app.AppCompatActivity
import com.example.taskoneweeklysix.R

object FragmentManager {
    private var currentFragOne: BaseFragment? = null
    private var currentFraqTwo: BaseFragment? = null

    fun setFragmentOne(newFrag: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frOne, newFrag)
        transaction.commit()
        currentFragOne = newFrag
    }
    fun setFragmentTwo(newFrag: BaseFragment, activity: AppCompatActivity) {
        val transaction = activity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frTwo, newFrag)
        transaction.commit()
        currentFraqTwo = newFrag
    }
}