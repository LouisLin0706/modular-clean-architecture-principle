package com.louis.core.presentation.dramas

import android.view.View
import com.louis.core.R
import com.louis.core.arch.BaseViewHolder
import com.louis.core.common.GlideApp
import com.louis.data.database.drama.model.CacheDrama
import kotlinx.android.synthetic.main.adapter_drama_item.*

class DramaViewHolder(itemView: View) : BaseViewHolder(itemView) {

    companion object {
        val LAYOUT_ID = R.layout.adapter_drama_item
    }

    fun bindView(drama: CacheDrama) {
        textview_name.text = drama.dramaName
        textview_views.text = drama.totalViews.toString()
        GlideApp.with(itemView.context)
            .load(drama.thumbUrl)
            .into(imageview_poster)
    }
}