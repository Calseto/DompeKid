package com.example.dompekid.adapter

import com.example.dompekid.databinding.ItemPocket2Binding
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dompekid.R
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.ItemPocketBinding

class AllowanceAdapter (
    private val data:List<PocketDataResponse?>?,
): RecyclerView.Adapter<AllowanceAdapter.AllowanceViewHolder>() {

    inner class AllowanceViewHolder(private val itemBinding:ItemPocket2Binding ):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: PocketDataResponse?){
            itemBinding.apply {
                tvTitlePocketItem2.text=model?.name
                tvBalancePockeItem2.text=model?.saldo.toString()
                if(model?.target!=null){
                    tvExpirePocketItem2.text=model.target.toString()
                }
                else tvExpirePocketItem2.visibility=View.INVISIBLE
                when(model?.jenisPocket){
                    "Tabungan"-> bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(this@AllowanceViewHolder.itemView.context, R.color.green)
                    )
                    "UangSaku"-> bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(this@AllowanceViewHolder.itemView.context, R.color.red)
                    )
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllowanceViewHolder {
        return AllowanceViewHolder(
            ItemPocket2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun getItemCount(): Int = data!!.size

    override fun onBindViewHolder(holder: AllowanceViewHolder, position: Int) {
        holder.bind(data!![position])
    }
}