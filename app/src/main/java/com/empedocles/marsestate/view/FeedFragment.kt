package com.empedocles.marsestate.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.empedocles.marsestate.adapter.EstateAdapter
import com.empedocles.marsestate.databinding.FragmentFeedBinding
import com.empedocles.marsestate.viewmodel.FeedViewModel

class FeedFragment : Fragment() {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: FeedViewModel
    private var estateAdapter = EstateAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFeedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FeedViewModel::class.java]
        viewModel.getFromApi()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = estateAdapter
        }
        observeLiveData()
    }

    // Observe viewmodel livedata changes
    private fun observeLiveData() {
        viewModel.estates.observe(viewLifecycleOwner) {
            it?.let {
                estateAdapter.updateEstateList(it)
            }
        }
    }
}