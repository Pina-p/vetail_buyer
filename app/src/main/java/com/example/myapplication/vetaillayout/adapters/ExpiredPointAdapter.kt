package com.example.myapplication.vetaillayout.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.databinding.MemberPointHistoryCardBinding
import com.example.myapplication.vetaillayout.model.ExpiredPointData

class ExpiredPointAdapter(
    var expiredPointList : ArrayList<ExpiredPointData>,
    var aName:String
) : RecyclerView.Adapter<ExpiredPointAdapter.ExpiredPointHolder>() {
    inner class ExpiredPointHolder(private val binding : MemberPointHistoryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(expiredPointList : ExpiredPointData){
            if(aName.equals("shopDetailPoint")){
                binding.civSubProfile.visibility = View.GONE
            }else{
                binding.civSubProfile.visibility = View.VISIBLE
            }
            binding.civProfile.setImageResource(expiredPointList.profile)
            binding.civSubProfile.setImageResource(expiredPointList.subProfile)
            binding.tvTime.text=expiredPointList.time
            binding.tvName.text =expiredPointList.name

            if (expiredPointList.point.isNotEmpty()){
                if (expiredPointList.isReceive){
                    binding.tvPoints.isVisible=true
                    binding.tvPoints.text= "+"+expiredPointList.point
                    binding.tvPoints.setTextColor(Color.parseColor("#FFB001"))
                    binding.tvPointText.setTextColor(Color.parseColor("#FFB001"))
                }else{
                    binding.tvPoints.isVisible=true
                    binding.tvPoints.text= "-"+expiredPointList.point
                    binding.tvPoints.setTextColor(Color.parseColor("#FC4D4E"))
                    binding.tvPointText.setTextColor(Color.parseColor("#FC4D4E"))
                }
            }else{
                binding.tvPoints.isVisible=false
                binding.tvPointText.isVisible=false
            }

            binding.tvMessage.text = expiredPointList.message
            if (expiredPointList.changedLevel.isNullOrEmpty()){
                binding.tvLevelChange.isVisible=false
            }else{
                binding.tvLevelChange.text = expiredPointList.changedLevel
            }

            if (expiredPointList.discount.isNullOrEmpty()){
                binding.llOff.isVisible=false
            }else{
                binding.tvOff.text = expiredPointList.discount
            }

            if (expiredPointList.orderId.isNullOrEmpty()){
                binding.llOrderId.isVisible=false
            }else{
                binding.tvOrderId.text = expiredPointList.orderId
            }

            if (expiredPointList.money.isNullOrEmpty()){
                binding.llMoney.isVisible=false
            }else{
                binding.tvMoney.text = expiredPointList.money
            }

            if (expiredPointList.comment.isNullOrEmpty()){
                binding.llComment.isVisible=false
            }else{
                binding.tvComment.text = expiredPointList.comment
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpiredPointHolder {
        return ExpiredPointHolder(MemberPointHistoryCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ExpiredPointHolder, position: Int) {
        holder.bind(expiredPointList[position])
    }

    override fun getItemCount(): Int {
        return expiredPointList.size
    }


}