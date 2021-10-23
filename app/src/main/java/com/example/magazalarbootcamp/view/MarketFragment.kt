package com.example.magazalarbootcamp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.magazalarbootcamp.R
import com.example.magazalarbootcamp.adapters.MarketAdapter
import com.example.magazalarbootcamp.databinding.FragmentMarketBinding
import com.example.magazalarbootcamp.model.Market
import com.example.magazalarbootcamp.model.MarketCevap
import com.example.magazalarbootcamp.webservis.ApiUtils
import com.example.magazalarbootcamp.webservis.MagazaDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MarketFragment : Fragment() {
    private var _binding:FragmentMarketBinding?=null
    private val binding get() = _binding!!
    private lateinit var dao:MagazaDao
    private lateinit var adapter: MarketAdapter
    private lateinit var marketList: ArrayList<Market>
    private val args:MarketFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentMarketBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao=ApiUtils.getDao()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarMarket.title=args.kategori.kategoriAd
            rvMarket.layoutManager= GridLayoutManager(context,2)
            rvMarket.setHasFixedSize(true)
            market(args.kategori.kategoriId.toInt())
        }

    }

    private fun market(id:Int){
        marketList= ArrayList()

        dao.magazaGetir(id).enqueue(object :Callback<MarketCevap>{
            override fun onResponse(call: Call<MarketCevap>, response: Response<MarketCevap>) {
                if (response.isSuccessful){
                    val liste=response.body()?.magazalar
                    liste?.let {
                        marketList=liste as ArrayList<Market>
                    }
                    adapter= MarketAdapter(requireContext(),marketList)
                    binding.rvMarket.adapter=adapter
                }
            }

            override fun onFailure(call: Call<MarketCevap>, t: Throwable) {
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}