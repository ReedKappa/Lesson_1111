package com.example.lesson_1111.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.lesson_1111.R
import com.example.lesson_1111.UiState
import com.example.lesson_1111.databinding.FragmentLampBinding
import com.example.lesson_1111.di.ViewModelFactory
import com.example.lesson_1111.di.appComponent
import javax.inject.Inject

class LampFragment: Fragment(R.layout.fragment_lamp), View.OnClickListener {
    private val binding: FragmentLampBinding by viewBinding()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: LampViewModel by viewModels() {viewModelFactory}

    override fun onAttach(context: Context) {
        context.appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getColorsNames()

        binding.buttonTurnOn.setOnClickListener(this)
        binding.buttonTurnOff.setOnClickListener(this)
        binding.buttonChangeColor.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_change_color -> {
                val value = viewModel.colorNames.value
                if (value is UiState.Success) {
                    viewModel.changeColor(value.value.random())
                }
            }
            R.id.button_turn_on -> {
                viewModel.turnLampOn()
            }
            R.id.button_turn_off -> {
                viewModel.turnLampOff()
            }
        }
    }


}