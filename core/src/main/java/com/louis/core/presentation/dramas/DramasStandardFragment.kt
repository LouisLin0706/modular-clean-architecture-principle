package com.louis.core.presentation.dramas

import android.arch.lifecycle.Observer
import android.content.res.Configuration
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.louis.core.arch.BaseFragment
import com.louis.core.common.utils.dp2px
import com.louis.core.data.LoadingState
import com.louis.core.data.Resource
import com.louis.core.presentation.base.OnItemClickListener
import com.louis.core.routing.FeatureInfoRouter
import com.louis.domain.model.Drama
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Represent one of product page type
 * Support:
 * - Default column 2
 * - LandScape will be 4 column
 * TODO Maybe has tablet case in feature
 */
class DramasStandardFragment : BaseFragment() {

    private val dramasViewModel: DramasViewModel by viewModel()
    private val featureInfoRouter: FeatureInfoRouter by inject()
    private var isViewCreated = false

    companion object {
        const val KEY_COLUMN = "key_column"
        const val DEFAULT_COLUMN = 2

        fun newInstance(portraitColumn: Int = DEFAULT_COLUMN): DramasStandardFragment {
            val bundle = Bundle().apply {
                putInt(KEY_COLUMN, portraitColumn)
            }
            return DramasStandardFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(com.louis.core.R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkColumn()
        val dramasAdapter = DramasAdapter()
        recyclerview_dramas.adapter = dramasAdapter
        recyclerview_dramas.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect?,
                view: View?,
                parent: RecyclerView?,
                state: RecyclerView.State?
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect?.set(dp2px(4f), 0, dp2px(4f), dp2px(8f))
            }
        })
        dramasViewModel.dramas.observe(this, Observer {
            when (it!!.status) {
                Resource.Status.SUCCESS -> {
                    dramasAdapter.setData(it.data ?: emptyList())
                }
                Resource.Status.ERROR -> {
                    it.exception?.run {
                        Toast.makeText(activity, this.errorMessage, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        dramasViewModel.loadingState.observe(this, Observer {
            when (it!!.status) {
                LoadingState.Status.HIDE -> swipe_refresh.isRefreshing = false
                LoadingState.Status.SHOW -> swipe_refresh.isRefreshing = true
            }
        })
        swipe_refresh.setOnRefreshListener {
            dramasViewModel.fetchDramas()
        }
        dramasViewModel.fetchDramas()
        dramasAdapter.onItemClick = object : OnItemClickListener<Drama> {
            override fun onItemClick(position: Int, data: Drama, view: View) {
                featureInfoRouter.showProductInfo(activity!!)
            }
        }
        isViewCreated = true
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        checkColumn()
    }

    private fun checkColumn() {
        val portraitColumn = arguments!!.getInt(KEY_COLUMN)
        val landscapeColumn = portraitColumn * 2
        if (activity!!.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerview_dramas.layoutManager = getLayoutManager(portraitColumn)
        } else {
            recyclerview_dramas.layoutManager = getLayoutManager(landscapeColumn)
        }
    }

    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)
        if (menuVisible && isAdded && isViewCreated) {
            checkColumn()
        }
    }

    private fun getLayoutManager(column: Int): GridLayoutManager {
        return GridLayoutManager(activity, column)
    }
}