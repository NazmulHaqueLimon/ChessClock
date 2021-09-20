package com.example.chessclock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.chessclock.databinding.FragmentChessFormatsBinding
import com.example.chessclock.databinding.HomeFragmentBinding


class ChessFormats : Fragment() {

    private lateinit var binding: FragmentChessFormatsBinding
    private val viewModel:ClockViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding= FragmentChessFormatsBinding.inflate(inflater,container,false)
        context ?: return binding.root


        binding.apply {
            buttonClassic1
        }



        return binding.root
    }


}