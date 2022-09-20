package com.example.myapplication.vetaillayout.activity

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.databinding.ActivitySignUpFinishActiviyBinding
import kotlinx.android.synthetic.main.item_dialog_box.*
import java.util.regex.Pattern

class SignUpFinishActiviy : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpFinishActiviyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpFinishActiviyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
        textChangeListener()
    }

    //warning The code is Overly Nested
    //current errors - One Alpha and One Num Regex is not working
    private fun textChangeListener() {
        val passwordOneAlpha = Pattern.compile("^(?=.*[a-zA-Z])$")
        val passwordSixDigit = Pattern.compile("^.{6,}$")
        val passwordOneNum = Pattern.compile("^(?=.*[0-9])$")
        binding.etName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvWelcomeText.visibility= View.GONE
                binding.tvWelcomeTextMini.visibility=View.GONE
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (
                    !p0.isNullOrEmpty()
                    //&& !binding.etMail.text.toString().isNullOrEmpty()
                    && !binding.etPw.text.toString().isNullOrEmpty()
                    && !binding.etPwConfirm.text.toString().isNullOrEmpty()
                ) {
                    binding.btnSignUp.isEnabled = true
                    binding.btnSignUp.background =
                        resources.getDrawable(R.drawable.custom_button_blue)
                } else if (!p0.isNullOrEmpty()) {
                                binding.etPw.addTextChangedListener(object : TextWatcher {
                                    override fun beforeTextChanged(
                                        p0: CharSequence?,
                                        p1: Int,
                                        p2: Int,
                                        p3: Int
                                    ) {
                                        binding.tvWelcomeText.visibility= View.GONE
                                        binding.tvWelcomeTextMini.visibility=View.GONE
                                    }

                                    override fun onTextChanged(
                                        p0: CharSequence?,
                                        p1: Int,
                                        p2: Int,
                                        p3: Int
                                    ) {
                                        if (
                                            !binding.etName.text.toString().isNullOrEmpty()
                                           // && !binding.etMail.text.toString().isNullOrEmpty()
                                            && !p0.isNullOrEmpty()
                                            && !binding.etPwConfirm.text.toString().isNullOrEmpty()
                                        ) {
                                            binding.btnSignUp.isEnabled = true
                                            binding.btnSignUp.background =
                                                resources.getDrawable(R.drawable.custom_button_blue)
                                        } else if (!p0.isNullOrEmpty()) {
                                            binding.etPwConfirm.addTextChangedListener(object :
                                                TextWatcher {
                                                override fun beforeTextChanged(
                                                    p0: CharSequence?,
                                                    p1: Int,
                                                    p2: Int,
                                                    p3: Int
                                                ) {
                                                    binding.tvWelcomeText.visibility= View.GONE
                                                    binding.tvWelcomeTextMini.visibility=View.GONE
                                                }

                                                override fun onTextChanged(
                                                    p0: CharSequence?,
                                                    p1: Int,
                                                    p2: Int,
                                                    p3: Int
                                                ) {
                                                    if (
                                                        !binding.etName.toString().isNullOrEmpty()
                                                        //&& !binding.etMail.text.toString().isNullOrEmpty()
                                                        && !binding.etPw.text.toString()
                                                            .isNullOrEmpty()
                                                        && !p0.isNullOrEmpty()
                                                    ) {
                                                        binding.btnSignUp.isEnabled = true
                                                        binding.btnSignUp.background =
                                                            resources.getDrawable(R.drawable.custom_button_blue)
                                                    } else if (!p0.isNullOrEmpty()) {
                                                        binding.btnSignUp.isEnabled = true
                                                        binding.btnSignUp.background =
                                                            resources.getDrawable(R.drawable.custom_button_blue)

                                                    } else {
                                                        binding.btnSignUp.isEnabled = false
                                                        binding.btnSignUp.background =
                                                            resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                                                    }
                                                    // This check password
                                                    if (p0 != null) {
                                                        val checkText = p0
                                                        val sixDigits =
                                                            passwordSixDigit.matcher(checkText)
                                                        val oneAlpha =
                                                            passwordOneAlpha.matcher(checkText)
                                                        val oneNum =
                                                            passwordOneNum.matcher(checkText)


                                                        (if (!oneAlpha.matches()) {
                                                            Log.d(
                                                                "PwCheck",
                                                                "One ${oneAlpha.matches()}"
                                                            )
                                                            binding.tvPwCheckOneAlpha.setTextColor(
                                                                resources.getColor(R.color.greyer)
                                                            )
                                                            binding.ivPwCheckOneAlpha.setImageResource(
                                                                R.drawable.ic_union
                                                            )
                                                        } else {
                                                            binding.tvPwCheckOneAlpha.setTextColor(
                                                                resources.getColor(R.color.black)
                                                            )
                                                            binding.ivPwCheckOneAlpha.setImageResource(
                                                                R.drawable.ic_correct_24
                                                            )
                                                        })

                                                        (if (!sixDigits.matches()) {
                                                            Log.d(
                                                                "PwCheck",
                                                                "Two ${sixDigits.matches()}"
                                                            )
                                                            binding.tvPwCheckSixDigit.setTextColor(
                                                                resources.getColor(R.color.greyer)
                                                            )
                                                            binding.ivPwCheckSixDigit.setImageResource(
                                                                R.drawable.ic_union
                                                            )

                                                        } else {

                                                            binding.tvPwCheckSixDigit.setTextColor(
                                                                resources.getColor(R.color.black)
                                                            )
                                                            binding.ivPwCheckSixDigit.setImageResource(
                                                                R.drawable.ic_correct_24
                                                            )
                                                        })

                                                        (if (!oneNum.matches()) {
                                                            Log.d(
                                                                "PwCheck",
                                                                "Three ${oneNum.matches()}"
                                                            )
                                                            binding.tvPwCheckOneNum.setTextColor(
                                                                resources.getColor(R.color.greyer)
                                                            )
                                                            binding.ivPwCheckOneNum.setImageResource(
                                                                R.drawable.ic_union
                                                            )
                                                        } else {

                                                            binding.tvPwCheckOneNum.setTextColor(
                                                                resources.getColor(R.color.black)
                                                            )
                                                            binding.ivPwCheckOneNum.setImageResource(
                                                                R.drawable.ic_correct_24
                                                            )

                                                        })
                                                    }

                                                    //Checking password End here
                                                }
                                                override fun afterTextChanged(p0: Editable?) {
                                                }
                                            })
                                        } else {
                                            binding.btnSignUp.isEnabled = false
                                            binding.btnSignUp.background =
                                                resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                                        }
                                    }

                                    override fun afterTextChanged(p0: Editable?) {
                                    }
                                })
                            } else {
                                binding.btnSignUp.isEnabled = false
                                binding.btnSignUp.background =
                                    resources.getDrawable(R.drawable.custom_button_invisibile_blue)
                            }
                        }
            override fun afterTextChanged(p0: Editable?) {
            }
        }
        )
    }

    fun onClick() {
        binding.ivBackButton.setOnClickListener {
            onBackPressed()
        }
        binding.btnSignUp.setOnClickListener {
            dialogShow()
        }
    }

    //    private var doubleBackToExitPressedOnce = false
//    override fun onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed()
//            return
//        }
//        dialogShow()
//        this.doubleBackToExitPressedOnce = true
//
//
//        Handler(Looper.getMainLooper()).postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2500)
//    }
    fun dialogShow() {
        var dialogBinding = LayoutInflater.from(this).inflate(R.layout.item_dialog_box, null)
        val myDialog = Dialog(this)
        myDialog.setContentView(dialogBinding)
        var Close = dialogBinding.findViewById<ImageView>(R.id.ivClose)
        Close.setOnClickListener {
            myDialog.cancel()
        }
        var DoBtn = dialogBinding.findViewById<AppCompatButton>(R.id.btnDo)
        DoBtn.setOnClickListener {
            Toast.makeText(this, "Account Created Loading animation Started", Toast.LENGTH_SHORT).show()
        }

        var DonBtn = dialogBinding.findViewById<AppCompatButton>(R.id.btnCancel)
        DonBtn.setOnClickListener {
            myDialog.cancel()
        }


        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        myDialog.show()
    }
}