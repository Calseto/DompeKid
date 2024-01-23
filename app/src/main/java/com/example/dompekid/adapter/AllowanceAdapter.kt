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
    private val onClick: (PocketDataResponse?)->Unit
): RecyclerView.Adapter<AllowanceAdapter.AllowanceViewHolder>() {

    private var optionalMethod:(itemBinding:ItemPocket2Binding)->Unit=({})

    inner class AllowanceViewHolder(private val itemBinding:ItemPocket2Binding ):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: PocketDataResponse?){
            optionalMethod.invoke(itemBinding)
            itemBinding.apply {
                tvTitlePocketItem2.text=model?.name
                tvBalancePockeItem2.text=model?.saldo.toString()
                if(model?.target!=null){
                    tvExpirePocketItem2.text=model.target.toString()
                }
                else tvExpirePocketItem2.visibility=View.INVISIBLE
                when(model?.jenisPocket){
                    "Tabungan"-> {
                        ivItemPocketIcon2.setImageResource(R.drawable.place_holder)
                        btnAllocateFund.setImageResource(R.drawable.btn_aloccate_fund)
                        bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                            ContextCompat.getColor(this@AllowanceViewHolder.itemView.context, R.color.green)
                        )
                    }
                    "UangSaku"-> {
                        ivItemPocketIcon2.setImageResource(R.drawable.place_holder2)
                        btnAllocateFund.setImageResource(R.drawable.btn_aloccate_fund2)
                        bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                            ContextCompat.getColor(this@AllowanceViewHolder.itemView.context, R.color.red)
                        )
                    }
                }
                bgPocketItem.setOnClickListener {
                    onClick.invoke(model)
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