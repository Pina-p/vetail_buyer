package com.example.myapplication.vetaillayout.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.vetaillayout.databinding.MemberPointHistoryCardBinding
import com.example.myapplication.vetaillayout.model.LevelChangedData

class RankChangedAdapter(
    var levelChangedList : ArrayList<LevelChangedData>,
    var aName : String
) : RecyclerView.Adapter<RankChangedAdapter.LevelChangedHolder>() {
    inner class LevelChangedHolder(private val binding : MemberPointHistoryCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(levelChangedList : LevelChangedData){
            if(aName.equals("shopDetailPoint")){
                binding.civSubProfile.visibility = View.GONE
            }else{
                binding.civSubProfile.visibility = View.VISIBLE
            }
            binding.civProfile.setImageResource(levelChangedList.profile)
            binding.civSubProfile.setImageResource(levelChangedList.subProfile)
            binding.tvTime.text=levelChangedList.time
            binding.tvName.text =levelChangedList.name

            if (levelChangedList.point==""){
                binding.tvPoints.isVisible=false
                binding.tvPointText.isVisible=false
            }else{
                binding.tvPoints.text = levelChangedList.point
                binding.tvPointText.isVisible=false
            }

            binding.tvMessage.text = levelChangedList.message
            if (levelChangedList.changedLevel==""){
                binding.tvLevelChange.isVisible=false
            }else{
                binding.tvLevelChange.text = levelChangedList.changedLevel
            }

            if (levelChangedList.discount==""){
                binding.llOff.isVisible=false
            }else{
                binding.tvOff.text = levelChangedList.discount
            }

            if (levelChangedList.orderId==""){
                binding.llOrderId.isVisible=false
            }else{
                binding.tvOrderId.text = levelChangedList.orderId
            }

            if (levelChangedList.money==""){
                binding.llMoney.isVisible=false
            }else{
                binding.tvMoney.text = levelChangedList.money
            }

            if (levelChangedList.comment==""){
                binding.llComment.isVisible=false
            }else{
                binding.tvComment.text = levelChangedList.comment
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LevelChangedHolder {
        return LevelChangedHolder(MemberPointHistoryCardBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: LevelChangedHolder, position: Int) {
        holder.bind(levelChangedList[position])
    }

    override fun getItemCount(): Int {
        return levelChangedList.size
    }


}