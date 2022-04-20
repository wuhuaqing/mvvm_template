
package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmActivityKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String
)="""
package ${mRootPackageName}.${mActivityPackageName}

import android.os.Bundle 
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath
import com.zn.common.base.BaseDbActivity
import com.zn.common.ext.initBack 
import com.zn.common.ext.getStringExt 
import $mRootPackageName.databinding.Activity${mPageName}Binding
import ${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel

@Route(path = RouterPath.**)
class ${mPageName}Activity : BaseDbActivity<${mPageName}ViewModel,Activity${mPageName}Binding>() {
    
      override fun initView(savedInstanceState: Bundle?) {
        mToolbar.initBack(getStringExt(R.string.mine_my_super)) {
            finish()
        } 
      }
}
"""
