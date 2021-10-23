package com.example.magazalarbootcamp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.magazalarbootcamp.R
import com.example.magazalarbootcamp.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {
    private var _binding:FragmentDetailBinding?=null
    private val binding get() = _binding!!
    private val argsMarket:DetailFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            Picasso.get().load("http://kasimadalan.pe.hu/magazalar/magazalogolar/${argsMarket.market.magazaResimAd}")
                .into(imageViewDetail)
            textViewDetailAd.text=argsMarket.market.magazaAd
            textViewAdres.text=argsMarket.market.magazaAdres
            textViewTel.text=argsMarket.market.magazaTel
            button.setOnClickListener {
                val action=DetailFragmentDirections.actionDetailFragmentToBrosurFragment(argsMarket.market.magazaId.toInt())
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}