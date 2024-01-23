package com.example.dompekid.presentation.main.createpocket


import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.dompekid.R
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.CreatePocketRequest
import com.example.dompekid.databinding.ComponentCreatePocketBinding
import com.example.dompekid.databinding.FragmentCreatePocketBinding
import com.example.dompekid.presentation.main.editpocket.TopUpPocketFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import java.math.BigInteger

@AndroidEntryPoint
class CreatePocketFragment:BaseFragment<FragmentCreatePocketBinding>() {

    private var status:Boolean = false
    private val viewModel:CreatePocketViewModel by viewModels()

    override fun inflateBinding(): FragmentCreatePocketBinding {
        return FragmentCreatePocketBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupSpinner()
        handleCreatePocket()
        observeViewModel()
        Handler().postDelayed({
            if(status==true) {
                val action =
                    TopUpPocketFragmentDirections.actionTopUpPocketFragmentToDashboardFragment()
                view?.findNavController()?.navigate(action)
            }
        },500)
    }

    private fun handleCreatePocket(){
        binding.btnCreateNewPocket.setOnClickListener {
            val name = binding.createPocketForm.edttxtNamaPocket.text.toString()
            var jenisPocket:String?=null
            var target:Int=0
            when(binding.createPocketForm.acTvCreatePocket.text.toString()){
                "Tabungan"->{
                    jenisPocket="T"
                    target=binding.createPocketForm.edttxtTargetFundPocket.text.toString().toInt()
                }
                "Uang Saku"->{
                    jenisPocket="J"
                    target=0
                }
                else->{
                    makeToast("Harap Pilih Jenis Pocket")
                }
            }
            if(jenisPocket!=null) {
                val createPocketRequest = CreatePocketRequest(name, jenisPocket, target)
                viewModel.updateData(createPocketRequest)
            }
        }
    }

    private fun observeViewModel(){
        viewModel.createPocketResponse.observe(viewLifecycleOwner){
            if(it?.statusCode==200){
                makeToast("Pembuatan Pocket Berhasil")
                status=true
            }
            else status=false
        }
    }

    private fun setupSpinner(){
        val pocketItemList = resources.getStringArray(R.array.jenisPocket)
        val spinnerAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item,pocketItemList)
        binding.createPocketForm.acTvCreatePocket.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                makeToast(binding.createPocketForm.acTvCreatePocket.text.toString())
                when(binding.createPocketForm.acTvCreatePocket.text.toString()){
                    "Tabungan"->{
                        binding.createPocketForm.tvTargetFundPocket.visibility=View.VISIBLE
                        binding.createPocketForm.edttxtTargetFundPocket.visibility=View.VISIBLE
                    }
                    "Uang Saku"->{
                        binding.createPocketForm.tvTargetFundPocket.visibility=View.GONE
                        binding.createPocketForm.edttxtTargetFundPocket.visibility=View.GONE
                    }
                    else->{
                        makeToast("Harap Pilih Jenis Pocket")
                    }
                }
            }

        })
        binding.createPocketForm.acTvCreatePocket.setAdapter(spinnerAdapter)
    }
}