package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmActivityKt(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String,
    mActivityLayoutName: String,
    mHasListWidget: Boolean,
): String {
    //创建recyclerView相关代码
    return if (mHasListWidget) {
        """
package ${mRootPackageName}.${mActivityPackageName}

import android.os.Bundle 
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath
import com.zn.common.base.BaseDbActivity 
import com.zn.common.ext.*
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import ${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel

@Route(path = RouterPath.**)
class ${mPageName}Activity : BaseDbActivity<${mPageName}ViewModel,${mActivityLayoutName}Binding>(),
OnItemChildClickListener, OnItemClickListener {

     private val mAdapter by lazy {
        ${mPageName}Adapter(null)
    }
    
     override fun showToolBar() = true
     
      override fun initView(savedInstanceState: Bundle?) {
        mToolbar.initBack(getStringExt(R.string.mine_my_super)) {
            finish()
        } 
        
         mDataBind.refreshLayout.refresh {
            mViewModel.loadData(true)
        }
        mDataBind.refreshLayout.loadMore {
            mViewModel.loadData(false)
        }
        
        mDataBind.recycler.apply {
            vertical()
            adapter = mAdapter
            //mAdapter.setEmptyView(emptyDataView(this))
            mAdapter.addChildClickViewIds(R.id.**) 
            mAdapter.setOnItemChildClickListener(this@${mPageName}Activity)
            mAdapter.setOnItemClickListener(this@${mPageName}Activity)
        }
      }
       
    override fun initObserver() {
        mViewModel.mDataLiveData.observe(this) {
            mAdapter.loadListSuccess(it, mDataBind.refreshLayout)
        } 
    }
    
    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
      //TODO item clicked
    }

    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
         //TODO item child clicked
    }

    
}

 
"""
    } else {
        """
package ${mRootPackageName}.${mActivityPackageName}

import android.os.Bundle 
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath
import com.zn.common.base.BaseDbActivity
import com.zn.common.ext.initBack 
import com.zn.common.ext.getStringExt  
import com.zn.common.ext.*
import ${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel

@Route(path = RouterPath.**)
class ${mPageName}Activity : BaseDbActivity<${mPageName}ViewModel,${mActivityLayoutName}Binding>() {
    
     override fun showToolBar() = true
     
      override fun initView(savedInstanceState: Bundle?) {
        mToolbar.initBack(getStringExt(R.string.mine_my_super)) {
            finish()
        } 
      }
}
"""
    }
}
