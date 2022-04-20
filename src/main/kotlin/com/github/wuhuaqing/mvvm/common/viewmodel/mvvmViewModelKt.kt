package com.github.wuhuaqing.mvvm.common.viewmodel

fun mvvmViewModelKt(
    mRootPackageName:String,
    mActivityPackageName:String,
    mPageName:String
) = """
package ${mRootPackageName}.${mActivityPackageName}
 
import com.zn.common.base.BaseViewModel
import com.zn.user.repository.UserRepository 
import com.zn.common.core.livedata.SingleLiveEvent
import com.zn.common.ext.rxHttpRequest
     
class ${mPageName}ViewModel  : BaseViewModel() {

    //TODO 样例代码 livedata
    val shareInfoEvent = SingleLiveEvent<Any>()
    
    //样例代码
    fun getUserInfo() {
        rxHttpRequest {
            onRequest = { 
                val shareInfo = ${mPageName}Repository.loadShareRegister()
                shareInfoEvent.value = shareInfo
            }
        }
    }
} 
"""
