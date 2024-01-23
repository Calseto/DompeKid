package com.example.dompekid.adapter

import android.content.res.ColorStateList
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dompekid.R
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.ItemPocketBinding

class PocketAdapter (
    private val data:List<PocketDataResponse?>?,private val onCLick:(PocketDataResponse?)->Unit
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
                    "Tabungan"-> {
                        ivItemPocketIcon1.setImageResource(R.drawable.place_holder)
                        bgPocketItem.backgroundTintList= ColorStateList.valueOf(ContextCompat.getColor(this@PocketViewHolder.itemView.context, R.color.green))
                    }
                    "UangSaku"->{
                        ivItemPocketIcon1.setImageResource(R.drawable.place_holder2)
                        bgPocketItem.backgroundTintList= ColorStateList.valueOf(ContextCompat.getColor(this@PocketViewHolder.itemView.context, R.color.red))
                    }
                }
            }

            itemBinding.bgPocketItem.setOnClickListener{
                onCLick.invoke(model)
                Log.d("TAG", "bisa di click")
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