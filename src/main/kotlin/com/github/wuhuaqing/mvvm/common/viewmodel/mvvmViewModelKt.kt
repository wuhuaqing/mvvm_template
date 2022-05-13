package com.github.wuhuaqing.mvvm.common.viewmodel

fun mvvmViewModelKt(
    mRootPackageName: String,
    mActivityPackageName: String,
    mPageName: String,
    mHasList: Boolean
): String {
    return if (mHasList) {
        """
package ${mRootPackageName}.${mActivityPackageName}
 
import com.zn.common.base.BaseViewModel
import androidx.lifecycle.MutableLiveData
import com.zn.net.entity.base.ApiPagerResponse
import com.zn.common.ext.rxHttpRequest
     
class ${mPageName}ViewModel  : BaseViewModel() {

    //TODO 样例代码 livedata
    val mDataLiveData = MutableLiveData<ApiPagerResponse<Any>>()
    private var pageIndex = 1
    
    //样例代码
    fun loadData(isRefresh: Boolean) {
        if (isRefresh) {
            //是刷新
            pageIndex = 1
        }
        rxHttpRequest {
            onRequest = {
                val data = ${mPageName}Repository.loadData(pageIndex, 10)
                pageIndex++
                mDataLiveData.value = data
            }
        }
    }
} 
"""
    } else {
        """
package ${mRootPackageName}.${mActivityPackageName}
 
import com.zn.common.base.BaseViewModel 
import com.zn.common.core.livedata.SingleLiveEvent
import com.zn.common.ext.rxHttpRequest
     
class ${mPageName}ViewModel  : BaseViewModel() {

    //TODO 样例代码 livedata
    val mDataLiveData = SingleLiveEvent<Any>()
    
    //样例代码
    fun loadData() {
        rxHttpRequest {
            onRequest = { 
                val data = ${mPageName}Repository.loadData()
                mDataLiveData.value = data
            }
        }
    }
} 
"""
    }
}
