
package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmLazyFragmentKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String,
    mActivityLayoutName:String,
)="""
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
