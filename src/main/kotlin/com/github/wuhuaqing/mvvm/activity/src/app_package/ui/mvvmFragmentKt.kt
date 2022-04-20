
package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmFragmentKt(
    mRootPackageName:String?,
    mActivityPackageName:String,
    mPageName:String
)="""
package ${mRootPackageName}.${mActivityPackageName}
 
import android.os.Bundle 
import com.zn.common.base.BaseDbFragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.zn.common.router.RouterPath
import $mRootPackageName.databinding.Fragment${mPageName}Binding
import ${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel


 @Route(path = RouterPath.**)
class ${mPageName}Fragment : BaseDbFragment<${mPageName}ViewModel,Fragment${mPageName}Binding>() {
  
  override fun initView(savedInstanceState: Bundle?) {
        
 
    }
}
"""
