
package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmActivityKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String
)="""
package ${mRootPackageName}.${mActivityPackageName}

import android.content.Intent
import android.os.Build
import android.os.Bundle 
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath
import $mRootPackageName.databinding.Activity${mPageName}Binding
import $mRootPackageName.R
import $mRootPackageName.base.BaseActivity
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
