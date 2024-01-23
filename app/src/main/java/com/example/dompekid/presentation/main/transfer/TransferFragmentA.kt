package com.example.dompekid.presentation.main.transfer

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dompekid.R
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionRequest
import com.example.dompekid.databinding.FragmentTransferABinding
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigInteger

@AndroidEntryPoint
class TransferFragmentA : BaseFragment<FragmentTransferABinding>(){
    private val viewModel:TransferFragmentAViewModel by viewModels()
    override fun inflateBinding(): FragmentTransferABinding {
        return FragmentTransferABinding.inflate(layoutInflater)
    }

    override fun setupView() {
        handleTransition()
        setUpPocketView()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.targetTransfer.observe(viewLifecycleOwner){
            if (it==null){
                makeToast("Rekening tidak ditemukan")
            }
            else{
                val pocket:PocketDataResponse?=arguments?.getParcelable("pocket")
                val nominal=binding.tvTransferNominal.text.toString()
                val penerima = it.data?.nomorRekening
                val transactionRequest = TransactionRequest(
                    idRekeningPenerima = penerima,
                    transferAmount = BigInteger(nominal),
                    idRekeningPengirim = null,
                    pocketId = pocket?.id
                )
                val bundle = bundleOf("target" to it.data,"request" to transactionRequest,"pocket" to pocket )
                val action = TransferFragmentADirections.actionTransferFragmentAToTransferFragmentB().actionId
                findNavController().navigate(action,bundle)
            }
        }
    }

    private  fun setUpPocketView(){
        val model:PocketDataResponse?=arguments?.getParcelable("pocket")
        binding.itemTopUp.apply {
            tvTitlePocketItem2.text=model?.name
            tvBalancePockeItem2.text=model?.saldo.toString()
            if(model?.target!=null){
                tvExpirePocketItem2.text=model.target.toString()
            }
            else tvExpirePocketItem2.visibility= View.INVISIBLE
            when(model?.jenisPocket){
                "Tabungan"-> {
                    ivItemPocketIcon2.setImageResource(R.drawable.place_holder)
                    btnAllocateFund.setImageResource(R.drawable.btn_aloccate_fund)
                    bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(requireContext(), R.color.green)
                    )
                }
                "UangSaku"-> {
                    ivItemPocketIcon2.setImageResource(R.drawable.place_holder2)
                    btnAllocateFund.setImageResource(R.drawable.btn_aloccate_fund2)
                    bgPocketItem.backgroundTintList= ColorStateList.valueOf(
                        ContextCompat.getColor(requireContext(), R.color.red)
                    )
                }
            }

        }
    }

    private fun handleTransition(){
        binding.btnPay.setOnClickListener{
            val rekId = binding.edttxtDestinationRek.text.toString()
            viewModel.updateData(rekId)
        }
    }
}