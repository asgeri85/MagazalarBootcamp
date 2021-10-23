package com.example.magazalarbootcamp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.magazalarbootcamp.databinding.CardKategoriBinding
import com.example.magazalarbootcamp.model.Kategori
import com.example.magazalarbootcamp.view.KategoriFragmentDirections

class KategoriAdapter(var mContext:Context,var kategoriler:ArrayList<Kategori>):RecyclerView.Adapter<KategoriAdapter.KategoriHolder>() {
    inner class KategoriHolder(var cardKategoriBinding: CardKategoriBinding):RecyclerView.ViewHolder(cardKategoriBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KategoriHolder {
        val view=CardKategoriBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return KategoriHolder(view)
    }

    override fun onBindViewHolder(holder: KategoriHolder, position: Int) {
        val kategori=kategoriler[position]
        holder.cardKategoriBinding.apply {
            textViewCardKategori.text=kategori.kategoriAd
            cardKategori.setOnClickListener {
                val action=KategoriFragmentDirections.actionKategoriFragmentToMarketFragment(kategori)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return kategoriler.size
    }
}