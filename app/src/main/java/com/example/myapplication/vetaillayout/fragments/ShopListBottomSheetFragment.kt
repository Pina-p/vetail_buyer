package com.example.myapplication.vetaillayout.fragments

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.vetaillayout.R
import com.example.myapplication.vetaillayout.activity.CarouselImageActivity
import com.example.myapplication.vetaillayout.adapters.ShopListItemsDetailRVAdapter
import com.example.myapplication.vetaillayout.databinding.FragmentShopListBottomSheetBinding
import com.example.myapplication.vetaillayout.model.ShopListItems
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ShopListBottomSheetFragment(val shopListItem: ShopListItems) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentShopListBottomSheetBinding

    override fun getTheme(): Int {
//        Toast.makeText(binding.root.context, "called", Toast.LENGTH_SHORT).show()
        return R.style.NoBackGroundDialogTheme
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        //comment is  to fix custom height of the bottom sheet
//        val peekHeightInPixels = 8000
//            dialog.behavior.peekHeight = peekHeightInPixels
        //to show all the content of the bottom sheet dialog
        dialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED
        return dialog
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShopListBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.tvItemName.text = shopListItem.itemName
//        if (shopListItem.hot) {
//            binding.ivHotIcon.visibility = View.VISIBLE
//            binding.tvHotText.visibility = View.VISIBLE
//        } else {
//            binding.tvHotText.visibility = View.INVISIBLE
//            binding.ivHotIcon.visibility = View.INVISIBLE
//        }
//        binding.tvEndTime.text = shopListItem.dateUntil
//        binding.tvItemPts.text = shopListItem.itemPoint
//        binding.tvAboutItem.text = shopListItem.aboutItem
        if (shopListItem.itemImage.size > 1) {
            //Toast.makeText(this@ShopListBottomSheetFragment.context, "${shopListItem.itemImage.size}", Toast.LENGTH_SHORT).show()
            var adapter = ShopListItemsDetailRVAdapter(shopListItem.itemImage)
            binding.rvImages.adapter = adapter
        }
        binding.tvBuyVetail.text = Html.fromHtml("ယခုဆုလက်ဆောင်အား " + "<b>" + "Ruby Energy (Lashio)" + "</b>" +
                " ဆီဆိုင်တွင် လဲလှယ်နိုင်ပါသည်။")
        binding.ivFullImage.setImageResource(shopListItem.itemImage[0])
        val lstContact: ArrayList<Int> = shopListItem.itemImage as ArrayList<Int>
        binding.ivFullImage.setOnClickListener {
                Intent(this@ShopListBottomSheetFragment.context, CarouselImageActivity::class.java)
                    .putExtra("carousel", lstContact).also { startActivity(it) }

            //Toast.makeText(this@ShopListBottomSheetFragment.context, "we send ${shopListItem.itemImage.size}", Toast.LENGTH_SHORT).show()
        }
        binding.rvImages.setOnClickListener {

        }

//        binding.tvItemPts.setOnClickListener {
//            binding.ivFullImage.setImageResource(ShopListItemsDetailRVAdapter(shopListItem.itemImage).img)
//            var noice =ShopListItemsDetailRVAdapter(shopListItem.itemImage).img
//            Toast.makeText(this.context, "${noice}", Toast.LENGTH_SHORT).show()
//        }
    }
}