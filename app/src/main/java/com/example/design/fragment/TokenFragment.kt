package com.example.design.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.design.Adapter

import com.example.design.R
import kotlinx.android.synthetic.main.fragment_token.*

class TokenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_token, container, false)
        val adapter = Adapter()
        val recyclerViewTokens: RecyclerView = view.findViewById(R.id.recyclerViewTokens)
        recyclerViewTokens.layoutManager = LinearLayoutManager(activity)
        recyclerViewTokens.adapter = adapter
        return view
    }
}
