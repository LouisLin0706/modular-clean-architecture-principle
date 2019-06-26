package com.louis

import android.content.Context
import android.content.Intent
import com.louis.core.routing.FeatureHomeRouter
import com.louis.core.routing.FeatureInfoRouter
import com.louis.feature_info.ProductInfoActivity

class FeatureHomeImpl : FeatureHomeRouter {
    override fun showFeatureHome(context: Context) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class FeatureInfoImpl : FeatureInfoRouter {
    override fun showProductInfo(context: Context) {
        context.startActivity(Intent(context, ProductInfoActivity::class.java))
    }

}
