package com.louis.core.common

import android.content.Context
import android.graphics.drawable.Drawable
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.module.AppGlideModule
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory

@GlideModule
class BaseGlideMode : AppGlideModule() {

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
        val transitionOptions = DrawableTransitionOptions.withCrossFade(
            DrawableCrossFadeFactory.Builder()
                .setCrossFadeEnabled(true)
        )
        builder.setDefaultTransitionOptions(Drawable::class.java, transitionOptions)
    }

    override fun isManifestParsingEnabled(): Boolean {
        return false
    }
}