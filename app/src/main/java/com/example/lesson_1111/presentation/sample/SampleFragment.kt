package com.example.lesson_1111.presentation.sample

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_1111.R
import com.example.lesson_1111.UiState
import com.example.lesson_1111.databinding.FragmentSampleBinding
import com.example.lesson_1111.di.ViewModelFactory
import com.example.lesson_1111.di.appComponent
import javax.inject.Inject

class SampleFragment : Fragment(R.layout.fragment_sample) {
    private val binding: FragmentSampleBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val adapter = TextViewAdapter()

    private val viewModel: SampleViewModel by viewModels() {viewModelFactory}

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecycler()
        super.onViewCreated(view, savedInstanceState)
        viewModel.jokesCategories.observe(viewLifecycleOwner) {
            showCategoriesList(it)
        }
        viewModel.getJokesCategories()
    }

    private fun initRecycler() = with(binding.recyclerCategories) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = this@SampleFragment.adapter
    }

    private fun showCategoriesList(uiState: UiState<List<String>>) {
        when (uiState) {
            is UiState.Loading -> {
                binding.recyclerCategories.visibility = View.GONE
                binding.progressCategories.visibility = View.VISIBLE

            }

            is UiState.Failure -> {
                binding.recyclerCategories.visibility = View.GONE
                binding.progressCategories.visibility = View.GONE

            }
            is UiState.Success -> {
                binding.progressCategories.visibility = View.GONE
                binding.recyclerCategories.visibility = View.VISIBLE
                adapter.submitList(uiState.value)
            }
        }
    }
}