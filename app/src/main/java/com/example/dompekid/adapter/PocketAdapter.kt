package com.example.dompekid.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dompekid.R
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.ItemPocketBinding

class PocketAdapter (
    private val data:List<PocketDataResponse?>?,
): RecyclerView.Adapter<PocketAdapter.PocketViewHolder>() {

    inner class PocketViewHolder(private val itemBinding:ItemPocketBinding ):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: PocketDataResponse?){
            itemBinding.apply {
                tvTitlePocketItem.text=model?.name
                tvBalancePockeItem.text=model?.saldo.toString()
                if(model?.target!=null){
                    tvExpirePocketItem.text=model.target.toString()
                }
                else tvExpirePocketItem.visibility=View.INVISIBLE
                when(model?.jenisPocket){
                    "Tabungan"-> bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(this@PocketViewHolder.itemView.context, R.color.green)
                    )
                    "UangSaku"-> bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(this@PocketViewHolder.itemView.context, R.color.red)
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PocketViewHolder {
        return PocketViewHolder(
            ItemPocketBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun getItemCount(): Int = data!!.size

    override fun onBindViewHolder(holder: PocketViewHolder, position: Int) {
        holder.bind(data!![position])
    }
}