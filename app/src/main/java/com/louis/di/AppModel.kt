package com.louis.di

import com.louis.FeatureHomeImpl
import com.louis.FeatureInfoImpl
import com.louis.core.di.coreModel
import com.louis.core.routing.FeatureHomeRouter
import com.louis.core.routing.FeatureInfoRouter
import com.louis.feature_home.di.homeModel
import org.koin.dsl.module

val router = module {
    single<FeatureHomeRouter> { FeatureHomeImpl() }
    single<FeatureInfoRouter> { FeatureInfoImpl() }
}
val appModel = listOf(coreModel, homeModel, router)