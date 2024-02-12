package com.harsh.fragmentactivityinteraction.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.harsh.fragmentactivityinteraction.Interfaces.ActivityInterface
import com.harsh.fragmentactivityinteraction.MainActivity
import com.harsh.fragmentactivityinteraction.R


class FirstFragment : Fragment(),ActivityInterface {
    lateinit var mainActivity: MainActivity
    var btnIncrement : Button ?= null
    var btnDecrement : Button ?= null
    var txtName : TextView ?= null
    var mainFrag : LinearLayout ?= null
    private val TAG = "FirstFragment"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity.activityInterface = this

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.txtName)
        btnIncrement = view.findViewById(R.id.btnIncrement)
        btnDecrement = view.findViewById(R.id.btnDecrement)
        mainFrag = view.findViewById(R.id.mainFrag)

        btnIncrement?.setOnClickListener(){
            mainActivity.incNumber()
        }
        btnDecrement?.setOnClickListener(){
            mainActivity.decNumber()
        }
    }

    companion object {

    }

    override fun getValue(text : String) {
        txtName?.setText(text)
        //mainFrag?.setBackgroundColor(ContextCompat.getColor(mainActivity,R.color.Red))

    }

    override fun changeColor(colorName: Int) {
        Log.e(TAG, "on color change $colorName")
        mainFrag?.setBackgroundColor(ContextCompat.getColor(mainActivity, colorName))
    }



}