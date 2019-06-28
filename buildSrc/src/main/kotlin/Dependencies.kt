@file:Suppress("unused", "MayBeConstant")

object Versions {
    val multiDex = "2.0.0"

    val aacCore = "2.0.0"
    val aac = "2.0.0"
    val room = "2.0.0"
    val roomKtx = "2.1.0"

    val appCompat = "1.0.2"
    val arrow = "0.7.3"
    val constraint = "1.1.3"
    val coroutines = "1.2.1"
    val coroutinesTest = "1.2.1"
    val koin = "2.0.1"
    val kotlin = "1.3.10"
    val mockk = "1.8.13.kotlin13"
    val navigation = "1.0.0-alpha06"
    val paging = "1.0.0"
    val retrofit = "2.5.0"
    val supportLib = "28.0.0"
    val testEspresso = "3.0.2"
    val testRunner = "1.0.2"
    val fragmentTestRule = "2.0.1"
    val material = "1.0.0"
    val glide = "4.8.0"
    val annotation = "1.0.0"
    val rxAndroid = "2.1.1"
    val rxJava = "2.2.0"
    val okhttpVersion = "3.12.0"
}

object Libs {
    val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val arrow = "io.arrow-kt:arrow-data:${Versions.arrow}"
    val material = "com.google.android.material:material:${Versions.material}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "android.arch.navigation:navigation-ui:${Versions.navigation}"
    val paging = "android.arch.paging:runtime:${Versions.paging}"
    val recycler = "com.android.support:recyclerview-v7:${Versions.supportLib}"
    val supportAppcompatV7 = "com.android.support:appcompat-v7:${Versions.supportLib}"
    val supportV4 = "com.android.support:support-v4:${Versions.supportLib}"
    val coreRunTime = "androidx.arch.core:core-runtime:${Versions.aacCore}"

    val core = "androidx.arch.core:core:${Versions.aacCore}"
    val coreTesting = "androidx.arch.core:core-testing:${Versions.aacCore}"

    //Network
    val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGson = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"

    //RxJava

    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxJava2 = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"

    //annotation
    val androidAnnotation = "androidx.annotation:annotation:${Versions.annotation}"

    //glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    val glideOkHttp = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"

    //corroutines
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val corroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    //aac
    val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.aac}"
    val liveData = "androidx.lifecycle:lifecycle-livedata:${Versions.aac}"

    //database
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.roomKtx}"

    //koin
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"


    //Test
    val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    val junit = "junit:junit:4.12"
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    val testRunner = "com.android.support.test:runner:${Versions.testRunner}"
    val testEspresso = "com.android.support.test.espresso:espresso-core:${Versions.testEspresso}"
    val testRules = "com.android.support.test:rules:${Versions.testRunner}"
    val fragmentTestRule = "com.21buttons:fragment-test-rule:${Versions.fragmentTestRule}"
    val fragmentTestRuleExtras = "com.21buttons:fragment-test-rule-extras:${Versions.fragmentTestRule}"
}