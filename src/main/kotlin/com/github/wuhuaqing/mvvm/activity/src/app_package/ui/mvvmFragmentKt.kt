package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmFragmentKt(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String,
    mActivityLayoutName: String,
    mHasListWidget: Boolean
): String {
    return if (mHasListWidget) {
        """
package ${mRootPackageName}.${mActivityPackageName}
 
import android.os.Bundle 
import android.view.View
import com.zn.common.base.BaseDbFragment
import com.chad.library.adapter.base.BaseQuickAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath 
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.zn.common.ext.*
import ${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel


 @Route(path = RouterPath.**)
class ${mPageName}Fragment : BaseDbFragment<${mPageName}ViewModel,${mActivityLayoutName}Binding>(),
OnItemChildClickListener, OnItemClickListener{
  
  
   private val mAdapter by lazy {
        ${mPageName}Adapter(null)
    }
  
  override fun initView(savedInstanceState: Bundle?) {
        
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
            mAdapter.setOnItemChildClickListener(this@${mPageName}Fragment)
            mAdapter.setOnItemClickListener(this@${mPageName}Fragment)
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
import com.zn.common.base.BaseDbFragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath 
import ${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel


 @Route(path = RouterPath.**)
class ${mPageName}Fragment : BaseDbFragment<${mPageName}ViewModel,${mActivityLayoutName}Binding>() {
  
  override fun initView(savedInstanceState: Bundle?) {
        
 
    }
}
"""
    }
}
