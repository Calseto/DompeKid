package com.example.dompekid.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionScene.Transition.TransitionOnClick
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.dompekid.R
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.ItemPocket2Binding

class SavingAdapter (
    private val data:List<PocketDataResponse?>?,
    private val onClick: (PocketDataResponse?)->Unit
): RecyclerView.Adapter<SavingAdapter.SavingViewHolder>() {

    inner class SavingViewHolder(private val itemBinding: ItemPocket2Binding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bind(model: PocketDataResponse?){
            itemBinding.apply {
                tvTitlePocketItem2.text=model?.name
                tvBalancePockeItem2.text=model?.saldo.toString()
                if(model?.target!=null){
                    tvExpirePocketItem2.text=model.target.toString()
                }
                else tvExpirePocketItem2.visibility= View.INVISIBLE
                when(model?.jenisPocket){
                    "Tabungan"-> bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(this@SavingViewHolder.itemView.context, R.color.green)
                    )
                    "UangSaku"-> bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(this@SavingViewHolder.itemView.context, R.color.red)
                    )
                }
                itemBinding.bgPocketItem.setOnClickListener {
                    onClick.invoke(model)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingViewHolder {
        return SavingViewHolder(
            ItemPocket2Binding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false))
    }

    override fun getItemCount(): Int = data!!.size

    override fun onBindViewHolder(holder: SavingViewHolder, position: Int) {
        holder.bind(data!![position])
    }
}