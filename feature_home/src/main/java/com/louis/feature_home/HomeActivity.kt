package com.louis.feature_home

import android.os.Bundle
import android.support.v4.view.ViewPager
import com.louis.core.arch.BaseActivity
import com.louis.core.presentation.base.TabFragmentAdapter
import com.louis.core.presentation.dramas.DramasStandardFragment
import kotlinx.android.synthetic.main.activity_home.*


/**
 * Home page contains several different category products page
 */
class HomeActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val tabFragmentAdapter = TabFragmentAdapter(supportFragmentManager)
        view_pager_tab.setTabIndicatorColorResource(R.color.brand_main_red)
        tabFragmentAdapter.addFragment(DramasStandardFragment.newInstance(),"Home")
        viewpager.adapter = tabFragmentAdapter
        viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
                val isNeedPrepareFirstLastPage = tabFragmentAdapter.count >= 3
                if (p0 == ViewPager.SCROLL_STATE_IDLE && isNeedPrepareFirstLastPage) {
                    val currentPosition = viewpager.currentItem
                    if (currentPosition == tabFragmentAdapter.count - 1) {
                        viewpager.setCurrentItem(1, false)
                    } else if (currentPosition == 0) {
                        viewpager.setCurrentItem(tabFragmentAdapter.count - 2, false)
                    }
                }
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
            }

        })
    }
}