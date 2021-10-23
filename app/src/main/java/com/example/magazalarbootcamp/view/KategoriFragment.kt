package com.example.magazalarbootcamp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.magazalarbootcamp.R
import com.example.magazalarbootcamp.adapters.KategoriAdapter
import com.example.magazalarbootcamp.databinding.FragmentKategoriBinding
import com.example.magazalarbootcamp.model.Kategori
import com.example.magazalarbootcamp.model.KategoriCevap
import com.example.magazalarbootcamp.webservis.ApiUtils
import com.example.magazalarbootcamp.webservis.MagazaDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KategoriFragment : Fragment() {
    private var _binding:FragmentKategoriBinding?=null
    private val binding get() = _binding!!
    private lateinit var dao:MagazaDao
    private lateinit var kategorilerList:ArrayList<Kategori>
    private lateinit var adapter:KategoriAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentKategoriBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao=ApiUtils.getDao()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            toolbarKategori.title="Kategoriler"
            (activity as AppCompatActivity).setSupportActionBar(toolbarKategori)
            rvKategori.layoutManager=LinearLayoutManager(context)
            rvKategori.setHasFixedSize(true)
            kategoriGetir()
        }

    }

    fun kategoriGetir(){
        kategorilerList=ArrayList()
        dao.tumKategori().enqueue(object :Callback<KategoriCevap>{
            override fun onResponse(call: Call<KategoriCevap>, response: Response<KategoriCevap>) {
                val liste=response.body()?.kategoriler
                liste?.let {
                    kategorilerList=liste as ArrayList<Kategori>
                }
                adapter= KategoriAdapter(requireContext(),kategorilerList)
                binding.rvKategori.adapter=adapter
            }

            override fun onFailure(call: Call<KategoriCevap>, t: Throwable) {
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}