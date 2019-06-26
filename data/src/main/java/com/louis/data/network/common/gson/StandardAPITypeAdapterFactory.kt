package com.louis.data.network.common.gson

/**
 * 處理 Drama3 API 回傳的固定格式，目前僅 EC 商品是如此。
 */

class StandardAPITypeAdapterFactory : GsonTypeAdapterFactory(JSON_DATA) {
    companion object {
        val JSON_DATA = "data"
    }
}