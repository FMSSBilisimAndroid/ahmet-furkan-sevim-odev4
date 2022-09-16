package com.empedocles.marsestate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.empedocles.marsestate.R
import com.empedocles.marsestate.databinding.FragmentFeedBinding
import com.empedocles.marsestate.databinding.FragmentProductBinding

class productFragment : Fragment() {
    private lateinit var binding : FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater)
        return binding.root
    }
}