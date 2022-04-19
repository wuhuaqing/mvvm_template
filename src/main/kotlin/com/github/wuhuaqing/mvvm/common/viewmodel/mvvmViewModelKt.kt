package com.github.wuhuaqing.mvvm.common.viewmodel

fun mvvmViewModelKt(
    mRootPackageName:String,
    mActivityPackageName:String,
    mPageName:String
) = """
package ${mRootPackageName}.${mActivityPackageName}

import androidx.lifecycle.ViewModel 
import com.zn.common.base.BaseViewModel
import com.zn.user.repository.UserRepository 
import com.zn.common.core.livedata.SingleLiveEvent
import com.zn.common.ext.rxHttpRequest
     
class ${mPageName}ViewModel  : BaseViewModel() {

    //TODO livedata
    val userDetailEvent = SingleLiveEvent<UserProfileBean>()
    
    fun getUserInfo() {
        rxHttpRequest {
            onRequest = {
                val userInfo = UserRepository.getUserInfo(PreferencesUtils.getUserId())
                userDetailEvent.value = userInfo
            }
        }
    }
} 
"""
