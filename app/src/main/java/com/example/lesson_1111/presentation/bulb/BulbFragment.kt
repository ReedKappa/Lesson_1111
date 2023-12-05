package com.example.lesson_1111.presentation.bulb

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_1111.R
import com.example.lesson_1111.UiState
import com.example.lesson_1111.databinding.FragmentBulbBinding
import com.example.lesson_1111.di.ViewModelFactory
import com.example.lesson_1111.di.appComponent
import javax.inject.Inject

class BulbFragment : Fragment(R.layout.fragment_bulb) {
    private val binding: FragmentBulbBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: BulbViewModel by viewModels { viewModelFactory }

    private val  adapter by lazy {
        ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        context.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.colorSpinner.adapter = this.adapter

        updateValues()
        binding.bulbStateSwitch.setOnCheckedChangeListener { _, state ->
            if (state)  viewModel.turnLampOn()
            else viewModel.turnLampOff()
        }
        binding.brightnessSlider.addOnChangeListener {_, value, _ ->
            viewModel.changeBrightness(value.toInt())
        }
        binding.colorSpinner.setOnItemSelectedListener(object:AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                viewModel.changeColor(adapter.getItem(p2).toString())
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        })
    }

    fun updateValues() {
        viewModel.getBulbState()
        viewModel.getColorsNames()
        viewModel.getCurrentColor()
        viewModel.getCurrentBrightnessLevel()

        viewModel.bulbState.observe(viewLifecycleOwner) {
            if (it is UiState.Success) {
                binding.bulbStateSwitch.isChecked = it.value
            }
        }

        viewModel.currentBrightnessLevel.observe(viewLifecycleOwner) {
            if (it is UiState.Success) {
                binding.brightnessSlider.value = it.value.toFloat()
            }
        }

        viewModel.colorNames.observe(viewLifecycleOwner) {
            if (it is UiState.Success) {
                adapter.addAll(it.value)
            }
        }

        viewModel.currentColor.observe(viewLifecycleOwner) {
            if (it is UiState.Success) {
                binding.colorSpinner.setSelection(adapter.getPosition(it.value.color))
            }
        }
    }
}