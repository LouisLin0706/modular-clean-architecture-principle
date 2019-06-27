@file:Suppress("unused", "MayBeConstant")

object Versions {
    val appCompat = "1.0.0-alpha1"
    val arrow = "0.7.3"
    val constraint = "1.1.3"
    val coreTesting = "1.1.1"
    val coroutines = "1.0.1"
    val coroutinesTest = "1.2.1"
    val koin = "1.0.1"
    val kotlin = "1.3.0"
    val mockk = "1.8.13.kotlin13"
    val navigation = "1.0.0-alpha06"
    val paging = "1.0.0"
    val retrofit = "2.4.0"
    val supportLib = "28.0.0"
    val testEspresso = "3.0.2"
    val testRunner = "1.0.2"
    val fragmentTestRule = "1.1.0"
}

object Libs {
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val arrow = "io.arrow-kt:arrow-data:${Versions.arrow}"
    val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraint}"
    val converterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val coreTesting = "android.arch.core:core-testing:${Versions.coreTesting}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val corroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val navigationFragment = "android.arch.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUi = "android.arch.navigation:navigation-ui:${Versions.navigation}"
    val paging = "android.arch.paging:runtime:${Versions.paging}"
    val recycler = "com.android.support:recyclerview-v7:${Versions.supportLib}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val supportAppcompatV7 = "com.android.support:appcompat-v7:${Versions.supportLib}"
    val supportV4 = "com.android.support:support-v4:${Versions.supportLib}"


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