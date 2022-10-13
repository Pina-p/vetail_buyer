package com.example.myapplication.vetaillayout.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.databinding.MemberPointHistoryCardBinding
import com.example.myapplication.vetaillayout.model.ReceivedPointData

class ReceivedPointAdapter(
    var receivedPointList : ArrayList<ReceivedPointData>
) : RecyclerView.Adapter<ReceivedPointAdapter.ReceivedPointHolder>() {
    inner class ReceivedPointHolder(private val binding : MemberPointHistoryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(receivedPointList : ReceivedPointData){
            binding.civProfile.setImageResource(receivedPointList.profile)
            binding.civSubProfile.setImageResource(receivedPointList.subProfile)
            binding.tvTime.text=receivedPointList.time
            binding.tvName.text =receivedPointList.name
            binding.tvPoints.text = receivedPointList.point
            binding.tvMessage.text = receivedPointList.message
            if (receivedPointList.changedLevel==""){
                binding.tvLevelChange.isVisible=false
            }else{
                binding.tvLevelChange.text = receivedPointList.changedLevel
            }

            if (receivedPointList.discount==""){
                binding.llOff.isVisible=false
            }else{
                binding.tvOff.text = receivedPointList.discount
            }

            if (receivedPointList.orderId==""){
                binding.llOrderId.isVisible=false
            }else{
                binding.tvOrderId.text = receivedPointList.orderId
            }

            if (receivedPointList.money==""){
                binding.llMoney.isVisible=false
            }else{
                binding.tvMoney.text = receivedPointList.money
            }

            if (receivedPointList.comment==""){
                binding.llComment.isVisible=false
            }else{
                binding.tvComment.text = receivedPointList.comment
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceivedPointHolder {
        return ReceivedPointHolder(MemberPointHistoryCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ReceivedPointHolder, position: Int) {
        holder.bind(receivedPointList[position])
        Log.d("OOOOOOOOO", "onBindViewHolder: $receivedPointList")
    }

    override fun getItemCount(): Int {
        return receivedPointList.size
    }
}