package com.example.chessclock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.chessclock.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: ClockViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= HomeFragmentBinding.inflate(inflater,container,false)
        context ?: return binding.root

        binding.apply {
            playerAClock
            playerBClock
            startButton.setOnClickListener {

            }
            pauseButton.setOnClickListener {

            }
            settingsButton.setOnClickListener {
                navigateToChessFormats()
            }
            playerAMoves
            playerBMoves
            playerATime
            playerBTime
        }


        return binding.root
    }

    private fun navigateToChessFormats() {
        TODO("Not yet implemented")
    }

}