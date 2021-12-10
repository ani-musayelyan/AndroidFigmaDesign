package com.example.androidfigma

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlin.math.log


class FirstFragment : Fragment(){
    private lateinit var transactionInterface: TransactionInterface

    private var signUp: Button? = null
    private var login : Button? = null

    val secondFragment = SecondFragment()
    val loginFragment = Login()
    val signUpFragment = SignUp()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        transactionInterface = activity as TransactionInterface

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        login = view.findViewById(R.id.login)
        login!!.setBackgroundDrawable(null)
        signUp = view.findViewById(R.id.sign_btn)


        login!!.setOnClickListener {
            openFragment(login , loginFragment )
        }

        signUp!!.setOnClickListener {
            openFragment(signUp , signUpFragment)
        }


        return view
    }


    fun openFragment(button: Button? , fragment: Fragment) {
        if (button == null) {
            Log.i("no_button","null button is null")
        } else {
                transactionInterface.replaceFragments(fragment)
            }
        }



}
