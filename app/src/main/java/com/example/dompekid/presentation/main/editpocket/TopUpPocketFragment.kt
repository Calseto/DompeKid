package com.example.dompekid.presentation.main.editpocket
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.TopUpRequest
import com.example.dompekid.databinding.FragmentTopupPocketBinding
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigInteger

@AndroidEntryPoint
class TopUpPocketFragment:BaseFragment<FragmentTopupPocketBinding>() {

    private val viewModel:TopUpPocketViewModel by viewModels()
    override fun inflateBinding(): FragmentTopupPocketBinding {
        return FragmentTopupPocketBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        val pocketData:PocketDataResponse?=arguments?.getParcelable("pocket")
        binding.itemTopUp.tvTitlePocketItem2.text=pocketData?.name
        binding.itemTopUp.tvBalancePockeItem2.text=pocketData?.saldo.toString()
        binding.itemTopUp.tvExpirePocketItem2.text=pocketData?.target.toString()

        handleTopUp(pocketData)
        observeViewModel()

    }

    private fun handleTopUp(pocketData:PocketDataResponse?){
        binding.btnTopUp.setOnClickListener{
            val nominal=binding.edttxtTopUP.text.toString()
            val id=pocketData?.id
            val request =TopUpRequest(BigInteger(nominal),id)
            viewModel.updateData(request)
            observeViewModel()

            Handler().postDelayed({
                val action = TopUpPocketFragmentDirections.actionTopUpPocketFragmentToDashboardFragment()
                view?.findNavController()?.navigate(action)
            },500)
        }
    }
    private fun observeViewModel(){
        viewModel.status.observe(viewLifecycleOwner){
            if (it==true){
                Toast.makeText(context, "Top Up Berhasil", Toast.LENGTH_SHORT).show()
                viewModel.resetLiveData()
            }
            if (it==false){
                Toast.makeText(context, "Top Up Gagal", Toast.LENGTH_SHORT).show()
                viewModel.resetLiveData()
            }

        }
    }
}