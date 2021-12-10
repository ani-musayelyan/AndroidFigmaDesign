package com.example.androidfigma

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.log

class SignUp : Fragment() {

    private lateinit var passData: PassData
    private lateinit var transactionInterface: TransactionInterface
    private val secondFragment = SecondFragment()

    private var nameEditText : EditText? = null
    private var createButton : Button? = null
    private var email_et : EditText? = null
    private var password_et : EditText? = null
    private var fields_tv : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        passData = activity as PassData
        transactionInterface = activity as TransactionInterface

        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        nameEditText = view.findViewById(R.id.name_editText)
        createButton = view.findViewById(R.id.create_button)
        email_et = view.findViewById(R.id.email_et)
        password_et = view.findViewById(R.id.password_et)
        fields_tv = view.findViewById(R.id.fields_tv)

        createButton!!.setOnClickListener {
            if (nameEditText!!.text.isNotEmpty() && email_et!!.text.isNotEmpty() && password_et!!.text.isNotEmpty() ) {
                passData.passData(nameEditText!!.text.toString() , secondFragment)
            } else {
                Log.i("koko" , "No name")
                fields_tv!!.visibility = View.VISIBLE
            }
        }


        return view
    }


}
