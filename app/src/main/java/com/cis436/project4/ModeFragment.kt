package com.cis436.project4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.cis436.project4.databinding.FragmentModeBinding

class ModeFragment : Fragment() {
    private lateinit var binding: FragmentModeBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentModeBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        binding.swMode.setOnClickListener{
            if (binding.swMode.isChecked) {
                viewModel.setMode("today")
                binding.tvMode.text = "Quote of the Day"
            } else {
                viewModel.setMode("random")
                binding.tvMode.text = "Random"
            }
        }

        return binding.root
    }
}