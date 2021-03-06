package com.louis.core.arch

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer

/**
 * Ref:https://kotlinlang.org/docs/tutorials/android-plugin.html
 */
open class BaseViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer