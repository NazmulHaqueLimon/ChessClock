package com.example.chessclock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.chessclock.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val clockViewModel: ClockViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= HomeFragmentBinding.inflate(inflater,container,false)
        context ?: return binding.root

        binding.lifecycleOwner =this
        binding.viewModel=clockViewModel

        binding.playerAClock.setOnClickListener {
            clockViewModel.startPlayerBTimer()
        }
        binding.playerBClock.setOnClickListener {
            clockViewModel.startPlayerATimer()
        }

        binding.startButton.setOnClickListener {
            clockViewModel._isGameRunning.value=true

        }
        binding.pauseButton.setOnClickListener {
            clockViewModel._isGameRunning.value =false
            clockViewModel.pauseTimer()
        }


        binding.settingsButton.setOnClickListener {
            clockViewModel.pauseTimer()
            navigateToChessFormats()
        }
        binding.resetButton.setOnClickListener {
            clockViewModel.resetClock()
        }


        return binding.root
    }

    private fun navigateToChessFormats() {
        findNavController().navigate(R.id.action_homeFragment_to_chessFormats)
    }

}