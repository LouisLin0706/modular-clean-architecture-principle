package com.louis.core.presentation.dramas

import android.view.LayoutInflater
import android.view.ViewGroup
import com.louis.core.presentation.base.ClickableAdapter
import com.louis.domain.model.Drama
/**
 * TODO feature paging
 */
class DramasAdapter : ClickableAdapter<Drama, DramaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DramaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(DramaViewHolder.LAYOUT_ID, parent, false)
        return DramaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holderViewHolder: DramaViewHolder, position: Int) {
        val drama = mData[position]
        holderViewHolder.bindView(drama)
        enableClickOnView(position, holderViewHolder.itemView, drama)
    }
}