package com.example.magazalarbootcamp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.magazalarbootcamp.databinding.CardBrosurBinding
import com.example.magazalarbootcamp.model.Brosur
import com.squareup.picasso.Picasso

class BrosurAdapter(var mContext:Context,var brosurler:ArrayList<Brosur>):RecyclerView.Adapter<BrosurAdapter.BrosurHolder>() {
    inner class BrosurHolder(var cardBrosurBinding: CardBrosurBinding):RecyclerView.ViewHolder(cardBrosurBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrosurHolder {
        val view=CardBrosurBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return BrosurHolder(view)
    }

    override fun onBindViewHolder(holder: BrosurHolder, position: Int) {
        val brosur=brosurler[position]
        holder.cardBrosurBinding.apply {
            Picasso.get().load("http://kasimadalan.pe.hu/magazalar/brosurler/${brosur.brosur_resim_ad}")
                .into(imageViewBrosur)
        }
    }

    override fun getItemCount(): Int {
        return brosurler.size
    }

}