package com.github.wuhuaqing.mvvm.common.repository

fun mvvmRepositoryKt(
    mRootPackageName: String,
    mActivityPackageName: String,
    mPageName: String,
    mHasList: Boolean
): String {
    return if (mHasList) {
        """
package ${mRootPackageName}.${mActivityPackageName}

import com.zn.net.api.NetUrl
import com.zn.net.entity.base.ApiPagerResponse
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse
    
    
object ${mPageName}Repository {

  //TODO 网络操作
  suspend fun loadData(page: Int, pageSize: Int): ApiPagerResponse<Any> {
        return RxHttp.get(NetUrl.USER_FOOTPRINT)
            .add("page", page)
            .add("limit", pageSize)
            .toResponse<ApiPagerResponse<Any>>()
            .await()
    }

    
} 
"""
    } else {
        """
package ${mRootPackageName}.${mActivityPackageName}

import com.zn.net.api.NetUrl
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse
    
    
object ${mPageName}Repository {

  //TODO 网络操作
  suspend fun loadData(): Any {
        return RxHttp.get(NetUrl.SHARE_REGISTER)
            .toResponse<Any>()
            .await()
    }
    
} 
"""
    }
}
