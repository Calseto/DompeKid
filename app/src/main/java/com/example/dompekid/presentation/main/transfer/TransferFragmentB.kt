package com.example.dompekid.presentation.main.transfer

import android.content.res.ColorStateList
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.dompekid.R
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.DataTransferTarget
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TransactionRequest
import com.example.dompekid.databinding.FragmentTransferBBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransferFragmentB : BaseFragment<FragmentTransferBBinding>() {

    private val viewModel:TransferFragmentBViewModel by viewModels()
    override fun inflateBinding(): FragmentTransferBBinding {
        return FragmentTransferBBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupPocketView()
        setUpTransferTarget()
        handleTransactionRequest()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.transaction.observe(viewLifecycleOwner){
            if (it?.statusCode==200){
                makeToast("Transaksi Berhasil Dilakukan")
                val action = TransferFragmentBDirections.actionTransferFragmentBToDashboardFragment()
                findNavController().navigate(action)
            }
            else{
                makeToast("Transaksi Gagal Dilakukan")
            }
        }
    }

    private fun handleTransactionRequest(){
        binding.btnConfirmTransfer.setOnClickListener {
            val transactionRequest:TransactionRequest?=arguments?.getParcelable("request")
            viewModel.updateData(transactionRequest)
        }
    }

    private fun setUpTransferTarget(){
        val target:DataTransferTarget? = arguments?.getParcelable("target")
        binding.apply {
            tvTransferTargetName.text=target?.name
            tvTransferTargetRek.text=target?.nomorRekening

        }
    }

    private fun setupPocketView() {
        val model: PocketDataResponse? = arguments?.getParcelable("pocket")
        val transactionRequest:TransactionRequest?=arguments?.getParcelable("request")
        binding.tvTransferNominal.text=transactionRequest?.transferAmount.toString()
        binding.itemTopUp.apply {
            tvTitlePocketItem2.text = model?.name
            tvBalancePockeItem2.text = model?.saldo.toString()
            if (model?.target != null) {
                tvExpirePocketItem2.text = model.target.toString()
            } else tvExpirePocketItem2.visibility = View.INVISIBLE
            when (model?.jenisPocket) {
                "Tabungan" -> {
                    ivItemPocketIcon2.setImageResource(R.drawable.place_holder)
                    btnAllocateFund.setImageResource(R.drawable.btn_aloccate_fund)
                    bgPocketItem.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(requireContext(), R.color.green)
                    )
                }

                "UangSaku" -> {
                    ivItemPocketIcon2.setImageResource(R.drawable.place_holder2)
                    btnAllocateFund.setImageResource(R.drawable.btn_aloccate_fund2)
                    bgPocketItem.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(requireContext(), R.color.red)
                    )
                }
            }

        }
    }
}