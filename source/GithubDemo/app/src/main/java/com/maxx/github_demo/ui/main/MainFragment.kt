package com.maxx.github_demo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.maxx.github_demo.databinding.MainFragmentBinding
import com.maxx.github_demo.model.Commit
import com.maxx.github_demo.ui.adapter.CommitAdapter
import com.maxx.github_demo.util.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding?.root!!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogEvents)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun subscribeObservers() {
        viewModel.dataState.observe(requireActivity(), Observer {
            when (it) {
                is DataState.Success<List<Commit>> -> {
                    displayProgressBar(false)
                    setUpRecyclerView(it.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(it.exception.message)

                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if (message != null) {
            binding?.dataTextView?.text = message.toString()
        } else {
            binding?.dataTextView?.text = "Unknown Error"
        }
    }

    private fun displayProgressBar(isDisplayed: Boolean) {
        binding?.progressBar?.visibility = if (isDisplayed) View.VISIBLE else View.GONE
    }

    private fun setUpRecyclerView(commits: List<Commit>) {
        binding?.recyclerView?.adapter = CommitAdapter(commits)
    }

}