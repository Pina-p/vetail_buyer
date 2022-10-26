package com.exam.homepage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.myapplication.vetaillayout.databinding.SwitchAccListItemBinding
import com.example.myapplication.vetaillayout.model.Account


class SwitchAccAdapter(
    var accounts : ArrayList<Account>
) : RecyclerView.Adapter<SwitchAccAdapter.SwitchAccHolder>() {
    private var selectedItem=-1
    inner class SwitchAccHolder(private val binding: SwitchAccListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(list : Account){

            binding.tvUserName.text= list.userName
            binding.ivProfile.load(list.userProfile){
                transformations(CircleCropTransformation())
            }

            binding.rbRadio.setOnClickListener{
                if(binding.rbRadio.isChecked){
                    selectedItem=adapterPosition
                    notifyDataSetChanged()
                }
            }
            binding.root.setOnClickListener{
                if(!binding.rbRadio.isChecked){
                    selectedItem=adapterPosition
                    notifyDataSetChanged()
                }
            }
            binding.rbRadio.isChecked=selectedItem==adapterPosition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwitchAccHolder {
        return SwitchAccHolder(SwitchAccListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: SwitchAccHolder, position: Int) {
        holder.bind(accounts[position])
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

}