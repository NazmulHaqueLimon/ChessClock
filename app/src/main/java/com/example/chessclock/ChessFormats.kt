package com.example.chessclock

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
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

        binding.lifecycleOwner =this
        binding.apply {
            buttonClassic1.setOnClickListener {
                viewModel.setFormat(3600000,0)
                findNavController().navigateUp()
            }
            buttonClassic2.setOnClickListener {
                viewModel.setFormat(1800000,0)
                findNavController().navigateUp()
            }
            buttonClassic3.setOnClickListener {
                viewModel.setFormat(2700000,45000)
                findNavController().navigateUp()
            }
            buttonRapid1.setOnClickListener {
                viewModel.setFormat(600000,5000)
                findNavController().navigateUp()
            }
            buttonRapid2.setOnClickListener {
                viewModel.setFormat(900000,10000)
                findNavController().navigateUp()
            }
            buttonRapid3.setOnClickListener {
                viewModel.setFormat(1200000,5000)
                findNavController().navigateUp()
            }
            buttonBlitz1.setOnClickListener {
                viewModel.setFormat(300000,2000)
                findNavController().navigateUp()
            }
            buttonBlitz2.setOnClickListener {
                viewModel.setFormat(180000,2000)
                findNavController().navigateUp()
            }
            buttonBlitz3.setOnClickListener {
                viewModel.setFormat(300000,5000)
                findNavController().navigateUp()
            }
            buttonBullet1.setOnClickListener {
                viewModel.setFormat(60000,2000)
                findNavController().navigateUp()
            }
            buttonBullet2.setOnClickListener {
                viewModel.setFormat(120000,1000)
                findNavController().navigateUp()
            }
            buttonBullet3.setOnClickListener {
                viewModel.setFormat(120000,2000)
                findNavController().navigateUp()
            }

        }


        return binding.root
    }

}