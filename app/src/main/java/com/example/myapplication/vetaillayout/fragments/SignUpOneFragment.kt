package com.example.myapplication.vetaillayout.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.SignUpActivity
import com.example.myapplication.vetaillayout.databinding.FragmentSignUpOneBinding

class SignUpOneFragment : Fragment() {
    private lateinit var binding: FragmentSignUpOneBinding
    val tempPhoneUserNum= "12345"
    val tempPhoneSellerNum= "67890"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpOneBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClicks()
        Log.d("Mingalar","onviewCreated")
    }

    fun onClicks(){
        var clickedOnce=false
        if (!clickedOnce){
            binding.btnSignUp.setOnClickListener {
                Log.d("Mingalar","setOnclicked")

                var text:String= binding.etPhNo.text.toString()
                if (text==tempPhoneUserNum){
                    binding.tvAccDuplicate.visibility= View.VISIBLE
                    binding.tilPhNo.boxStrokeColor=resources.getColor(R.color.red)
                    binding.tvAccDuplicate.text = getString(R.string.acc_exist_normal)
                }
                else if (text==tempPhoneSellerNum){
                    binding.tvAccDuplicate.visibility= View.VISIBLE
                    binding.tilPhNo.boxStrokeColor=resources.getColor(R.color.red)
                    binding.tvAccDuplicate.text = getString(R.string.acc_exist_shopdoora)
                }
                else{
                    binding.tilPhNo.boxStrokeColor=resources.getColor(R.color.blueOne)
                    binding.ivCorrect.visibility=View.VISIBLE
                    binding.tvAccDuplicate.visibility=View.GONE
                    binding.btnSignUp.text = getString(R.string.proceed)
                    clickedOnce=true
                }
            }
        }
        else if(clickedOnce){
            Intent(this.context,SignUpActivity::class.java).putExtra("changePage",1)
            Log.d("Mingalar","sent Intent")
        }
    }
}