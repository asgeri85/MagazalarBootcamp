package com.example.magazalarbootcamp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.magazalarbootcamp.databinding.CardMarketBinding
import com.example.magazalarbootcamp.model.Market
import com.example.magazalarbootcamp.view.MarketFragmentDirections
import com.squareup.picasso.Picasso

class MarketAdapter(var mContext:Context,var marketler:ArrayList<Market>):
    RecyclerView.Adapter<MarketAdapter.MarketHolder>() {
    inner class MarketHolder(var cardMarketBinding: CardMarketBinding):RecyclerView.ViewHolder(cardMarketBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketHolder {
        val view=CardMarketBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return MarketHolder(view)
    }

    override fun onBindViewHolder(holder: MarketHolder, position: Int) {
        val market=marketler[position]
        holder.cardMarketBinding.apply {
            textViewMarketAd.text=market.magazaAd
            Picasso.get().load("http://kasimadalan.pe.hu/magazalar/magazalogolar/${market.magazaResimAd}")
                .into(imageViewCardMarket)
            cardMarket.setOnClickListener {
                val action=MarketFragmentDirections.actionMarketFragmentToDetailFragment(market)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return marketler.size
    }
}