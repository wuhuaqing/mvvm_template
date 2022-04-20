package com.github.wuhuaqing.mvvm.common.repository

fun mvvmRepositoryKt(
    mRootPackageName:String,
    mActivityPackageName:String,
    mPageName:String
) = """
package ${mRootPackageName}.${mActivityPackageName}

import com.zn.net.api.NetUrl
import com.zn.user.entity.*
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse
    
    
object ${mPageName}Repository {

  //TODO 网络操作
  suspend fun loadShareRegister(): Any {
        return RxHttp.get(NetUrl.SHARE_REGISTER)
            .toResponse<Any>()
            .await()
    }
    
} 
"""
