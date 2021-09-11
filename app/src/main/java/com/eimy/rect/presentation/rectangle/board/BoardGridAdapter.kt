package com.eimy.rect.presentation.rectangle.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eimy.rect.R
import com.eimy.rect.databinding.ItemRectangleBoardBinding
import com.eimy.rect.presentation.model.RectangleType

class BoardGridAdapter(val clickListener: OnClickListener) :
    ListAdapter<RectangleType, BoardGridAdapter.RectangleViewHolder>(Companion) {

    companion object :
        DiffUtil.ItemCallback<RectangleType>() {
        override fun areItemsTheSame(oldItem: RectangleType, newItem: RectangleType) =
            false

        override fun areContentsTheSame(oldItem: RectangleType, newItem: RectangleType) =
            false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RectangleViewHolder {
        return RectangleViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_rectangle_board,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RectangleViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener, position)
    }

    override fun getItemCount(): Int = currentList.size


    inner class RectangleViewHolder(private val itemRectangleBoardBinding: ItemRectangleBoardBinding) :
        RecyclerView.ViewHolder(itemRectangleBoardBinding.root) {
        fun bind(RectangleType: RectangleType, clickListener: OnClickListener, position: Int) {
            itemRectangleBoardBinding.position = position
            itemRectangleBoardBinding.itemClickListener = clickListener
            itemRectangleBoardBinding.rectangle = RectangleType
            itemRectangleBoardBinding.executePendingBindings()
        }
    }
}

interface OnClickListener {
    fun onClick(position: Int)
}