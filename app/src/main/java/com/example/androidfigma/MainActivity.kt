package com.example.androidfigma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() , TransactionInterface ,PassData {

    private val firstFragment = FirstFragment()
   val secondFragment = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        supportFragmentManager.beginTransaction().add(R.id.container , firstFragment).commit()

    }


    override fun replaceFragments(fragment: Fragment) {
        val transaction  = this.supportFragmentManager.beginTransaction().
        replace(R.id.container , fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun passData(name: String , fragment: Fragment) {
        val bundle = Bundle()
        bundle.putString("name_input" , name)
        fragment.arguments = bundle
        replaceFragments(fragment)

//        val transaction  = this.supportFragmentManager.beginTransaction().
//        replace(R.id.container , secondFragment)
//        transaction.commit()
    }

}