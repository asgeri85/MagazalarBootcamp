package com.example.magazalarbootcamp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.magazalarbootcamp.R
import com.example.magazalarbootcamp.adapters.BrosurAdapter
import com.example.magazalarbootcamp.databinding.FragmentBrosurBinding
import com.example.magazalarbootcamp.model.Brosur
import com.example.magazalarbootcamp.model.BrosurCevap
import com.example.magazalarbootcamp.webservis.ApiUtils
import com.example.magazalarbootcamp.webservis.MagazaDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrosurFragment : Fragment() {
    private var _binding:FragmentBrosurBinding?=null
    private val binding get() = _binding!!
    private lateinit var dao:MagazaDao
    private lateinit var listBrosur:ArrayList<Brosur>
    private lateinit var adapter:BrosurAdapter
    private val args:BrosurFragmentArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding= FragmentBrosurBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dao=ApiUtils.getDao()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvBrosur.layoutManager=GridLayoutManager(context,2)
            rvBrosur.setHasFixedSize(true)
            brosurGetir(args.id)
        }
    }

    fun brosurGetir(id:Int){
        listBrosur=ArrayList()
        dao.brosurler(id).enqueue(object :Callback<BrosurCevap>{
            override fun onResponse(call: Call<BrosurCevap>, response: Response<BrosurCevap>) {
                if (response.isSuccessful){
                    val list=response.body()?.brosurler
                    list?.let {
                        listBrosur=it as ArrayList<Brosur>
                    }
                    adapter= BrosurAdapter(requireContext(),listBrosur)
                    binding.rvBrosur.adapter=adapter
                }

            }

            override fun onFailure(call: Call<BrosurCevap>, t: Throwable) {
            }

        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}