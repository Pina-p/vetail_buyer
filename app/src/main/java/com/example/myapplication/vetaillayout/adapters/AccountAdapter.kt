package com.example.myapplication.vetaillayout.adapters

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.DeleteAccActivity
import com.example.myapplication.vetaillayout.activity.FragmentContainerActivity
import com.example.myapplication.vetaillayout.activity.MainActivity
import com.example.myapplication.vetaillayout.databinding.*
import com.example.myapplication.vetaillayout.fragments.FragmentLoginAfterLogout
import com.example.myapplication.vetaillayout.model.*

class AccountAdapter (val list: List<Account>) :
    RecyclerView.Adapter<AccountAdapter.AccountHolder>() {



    inner class AccountHolder(private val binding: AccListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(list : Account){
            binding.ivUserProfile.load(list.userProfile){
                transformations(CircleCropTransformation())
            }
            binding.tvUserName.text = list.userName
            binding.ivRemoveAcc.setOnClickListener {
                var dialogBinding = LayoutInflater.from(itemView.context).inflate(R.layout.custom_alert_dialog_delete_acc,null)
                val myDialog = Dialog(itemView.context)
                var img = dialogBinding.findViewById<ImageView>(R.id.ivUserProfile)
                var ivClose = dialogBinding.findViewById<ImageView>(R.id.ivClose)
                var text = dialogBinding.findViewById<TextView>(R.id.tvUserName)
                img.load(list.userProfile){
                    transformations(CircleCropTransformation())
                }
                ivClose.setOnClickListener {
                    myDialog.dismiss()
                }
                text.text = list.userName+"\nအကောင့်ကို ဖယ်ရှားမည်"
                myDialog.setContentView(dialogBinding)
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountHolder {
        return AccountHolder(
            AccListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: AccountHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,FragmentContainerActivity::class.java)
            intent.putExtra("userProfile",list[position].userProfile)
            intent.putExtra("userName",list[position].userName)
            holder.itemView.context.startActivity(intent)
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }


}