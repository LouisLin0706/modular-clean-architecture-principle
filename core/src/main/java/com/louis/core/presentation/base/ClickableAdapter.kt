package com.louis.core.presentation.base

import androidx.recyclerview.widget.RecyclerView
import android.view.View

abstract class ClickableAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    protected var mData = emptyList<T>()

    fun setData(data: List<T>) {
        this.mData = data
        notifyDataSetChanged()
    }

    var onItemClick: OnItemClickListener<T>? = null

    protected fun enableClickOnView(position: Int, view: View, data: T) {
        view.setOnClickListener { onItemClick?.onItemClick(position, data, view) }
    }
}

interface OnItemClickListener<T> {
    fun onItemClick(position: Int, data: T, view: View)
}