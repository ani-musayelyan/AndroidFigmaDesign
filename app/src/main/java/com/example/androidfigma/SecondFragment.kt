package com.example.androidfigma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView


class SecondFragment : Fragment()  {

    var explore_tv : TextView? = null
    private var nameTextView : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.second, container, false)
        nameTextView = view.findViewById(R.id.name_textView)
        explore_tv = view.findViewById(R.id.explore_Tv)
        val animationFadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
        explore_tv!!.visibility = View.VISIBLE
        explore_tv!!.startAnimation(animationFadeIn)

        val name = arguments?.getString("name_input").toString()
        nameTextView!!.text = name


        return view
    }


}
