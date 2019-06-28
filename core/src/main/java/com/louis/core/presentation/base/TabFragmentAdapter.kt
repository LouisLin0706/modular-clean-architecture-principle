package com.louis.core.presentation.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


class TabFragmentAdapter(fragmentManager: FragmentManager) :
        FragmentStatePagerAdapter(fragmentManager) {

    private val registeredFragments = mutableListOf<Pair<String, Fragment>>()


    override fun getItem(position: Int): Fragment {
        return registeredFragments[position].second
    }

    override fun getCount(): Int {
        return registeredFragments.size
    }


    override fun getPageTitle(position: Int): CharSequence? {
        return registeredFragments.get(position).first
    }

    fun addFragment(fragment: Fragment, title: String) {
        registeredFragments.add(Pair(title, fragment))
    }

    fun addFragment(fragment: Fragment, title: String, position: Int) {
        registeredFragments.add(position, Pair(title, fragment))
    }
}