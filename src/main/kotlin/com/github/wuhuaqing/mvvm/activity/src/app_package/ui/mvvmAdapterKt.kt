package com.github.wuhuaqing.mvvm.activity.src.app_package.ui

fun mvvmAdapterKt(
    mRootPackageName: String?,
    mActivityPackageName: String,
    mPageName: String,
    transActivityBinding:String,
    mActivityLayoutName: String,
) =
    """
package ${mRootPackageName}.${mActivityPackageName}

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
 
class ${mPageName}Adapter(mutableList: MutableList<Any>?) : 
      BaseQuickAdapter<Any,BaseDataBindingHolder<${transActivityBinding}ItemBinding>>(
       R.layout.${mActivityLayoutName}_item,
       mutableList
      ){
      override fun convert(
        holder: BaseDataBindingHolder<${transActivityBinding}ItemBinding>,
        item: Any
      ) {
        val binding = holder.dataBinding
        binding?.run { //TODO View相关操作
           
         }
      }
      }

"""
