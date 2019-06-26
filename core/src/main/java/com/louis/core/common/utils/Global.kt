package com.louis.core.common.utils

import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics

fun getDisplayMetrics(): DisplayMetrics = Resources.getSystem().displayMetrics

fun dp2px(dpValue: Float): Int {
    return Math.round(dpValue * getDisplayMetrics().density)
}

fun px2dp(pxValue: Float): Int {
    return Math.round(pxValue / getDisplayMetrics().density)
}

fun sp2px(spValue: Float): Int {
    return Math.round(spValue * getDisplayMetrics().scaledDensity)
}

fun px2sp(pxValue: Float): Int {
    return Math.round(pxValue / getDisplayMetrics().scaledDensity)
}

fun isTablet(): Boolean {
    return Resources.getSystem().configuration.screenLayout and Configuration.SCREENLAYOUT_SIZE_MASK >= Configuration.SCREENLAYOUT_SIZE_LARGE
}