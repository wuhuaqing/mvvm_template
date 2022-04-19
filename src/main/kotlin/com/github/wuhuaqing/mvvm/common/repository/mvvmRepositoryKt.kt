package com.github.wuhuaqing.mvvm.common.repository

fun mvvmRepositoryKt(
    mRootPackageName:String,
    mActivityPackageName:String,
    mPageName:String
) = """
package ${mRootPackageName}.${mActivityPackageName}
import android.text.TextUtils 
import com.zn.net.api.NetUrl
import com.zn.user.entity.*
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse
    
    
class ${mPageName}Repository {

 suspend fun queryUserAccountInfo(): ** {
        return RxHttp.get(NetUrl.**)
            .toResponse<**>().await()
    }
    
} 
"""
