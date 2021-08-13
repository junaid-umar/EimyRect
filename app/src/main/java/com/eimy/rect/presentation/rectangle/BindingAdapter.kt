package com.eimy.rect.presentation.rectangle

import android.content.res.ColorStateList
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.eimy.rect.R
import com.eimy.rect.presentation.model.RectangleType
import com.eimy.rect.presentation.rectangle.board.BoardGridAdapter
import com.google.android.material.shape.MaterialShapeDrawable


@BindingAdapter("app:listItems")
fun bindListAdapter(recyclerView: RecyclerView, items: List<RectangleType>?) {
    val adapter = (recyclerView.adapter as BoardGridAdapter)

    if (!items.isNullOrEmpty()) {
        adapter.submitList(items)
    }
}

@BindingAdapter("app:viewColor")
fun bindViewColor(view: View, rectangleTyp: RectangleType) {
    Log.d("TAG", "bindViewColor: $rectangleTyp")
    val shapeDrawable = MaterialShapeDrawable()
    shapeDrawable.fillColor = getColor(rectangleTyp, view)
    shapeDrawable.setStroke(1.0f, ContextCompat.getColor(view.context, R.color.black))
    view.background = shapeDrawable

}

@BindingAdapter("app:textLargestRectangle")
fun setLargestRectangle(
    textView: TextView,
    largestRectangle: Int
) {

    textView.text = "Largest Rectangle: $largestRectangle"

}


private fun getColor(
    rectangleTyp: RectangleType,
    view: View
): ColorStateList? {
    return when (rectangleTyp) {
        RectangleType.NOT_SELECTED ->
            ContextCompat.getColorStateList(view.context, R.color.grey_light)
        RectangleType.SELECTED ->
            ContextCompat.getColorStateList(view.context, R.color.grey_dark)
        RectangleType.LARGEST ->
            ContextCompat.getColorStateList(view.context, R.color.red)
    }
}