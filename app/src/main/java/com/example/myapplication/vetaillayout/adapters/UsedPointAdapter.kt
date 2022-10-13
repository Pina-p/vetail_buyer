package com.example.myapplication.vetaillayout.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.databinding.MemberPointHistoryCardBinding

class UsedPointAdapter(
    var usedPointList : ArrayList<UsedPointData>
) : RecyclerView.Adapter<UsedPointAdapter.UsedPointHolder>() {
    inner class UsedPointHolder(private val binding : MemberPointHistoryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(usedPointList : UsedPointData){
            binding.civProfile.setImageResource(usedPointList.profile)
            binding.civSubProfile.setImageResource(usedPointList.subProfile)
            binding.tvTime.text=usedPointList.time
            binding.tvName.text =usedPointList.name

            if (usedPointList.isReceive==false){
                binding.tvPoints.setTextColor(Color.parseColor("#FC4D4E"))
                binding.tvPoints.text = "-"+usedPointList.point
                binding.tvPointText.setTextColor(Color.parseColor("#FC4D4E"))
            }

            binding.tvMessage.text = usedPointList.message
            if (usedPointList.changedLevel==""){
                binding.tvLevelChange.isVisible=false
            }else{
                binding.tvLevelChange.text = usedPointList.changedLevel
            }

            if (usedPointList.discount==""){
                binding.llOff.isVisible=false
            }else{
                binding.tvOff.text = usedPointList.discount
            }

            if (usedPointList.orderId==""){
                binding.llOrderId.isVisible=false
            }else{
                binding.tvOrderId.text = usedPointList.orderId
            }

            if (usedPointList.money==""){
                binding.llMoney.isVisible=false
            }else{
                binding.tvMoney.text = usedPointList.money
            }

            if (usedPointList.comment==""){
                binding.llComment.isVisible=false
            }else{
                binding.tvComment.text = usedPointList.comment
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsedPointHolder {
        return UsedPointHolder(MemberPointHistoryCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: UsedPointHolder, position: Int) {
        holder.bind(usedPointList[position])
    }

    override fun getItemCount(): Int {
        return usedPointList.size
    }


}