package com.techmania.chatappuidesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class RequestsFragment : Fragment() {

    companion object{
        fun newInstance() : RequestsFragment{
            return RequestsFragment()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.requests,container,false)
    }

}