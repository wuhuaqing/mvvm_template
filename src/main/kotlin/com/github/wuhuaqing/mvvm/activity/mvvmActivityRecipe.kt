package com.github.wuhuaqing.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.wuhuaqing.mvvm.activity.src.app_package.ui.mvvmActivityKt
import com.github.wuhuaqing.mvvm.activity.src.app_package.ui.mvvmAdapterKt
import com.github.wuhuaqing.mvvm.activity.src.app_package.ui.mvvmFragmentKt
import com.github.wuhuaqing.mvvm.common.repository.mvvmRepositoryKt
import com.github.wuhuaqing.mvvm.common.res.layout.mvvmItemXml
import com.github.wuhuaqing.mvvm.common.res.layout.mvvmXml
import com.github.wuhuaqing.mvvm.common.viewmodel.mvvmViewModelKt

fun RecipeExecutor.mvvmActivityRecipe(
    moduleTemplateData: ModuleTemplateData,
    mRootPackageName: String,
    mPageName: String,
    mIsActivity: Boolean,
    mActivityLayoutName: String,
    mIsGenerateActivityLayout: Boolean,
    mActivityPackageName: String,
    mIsUseHilt: Boolean,
    mIsFragment: Boolean,
    mFragmentLayoutName: String,
    mIsGenerateFragmentLayout: Boolean,
    mFragmentPackageName: String,
    mHasListWidget: Boolean
) {
    val (projectData, srcOut, resOut) = moduleTemplateData
    val ktOrJavaExt = projectData.language.extension

    if (mIsActivity) {
        //清单文件配置
        generateManifest(
            moduleData = moduleTemplateData,
            activityClass = "${mPageName}Activity",
            packageName = "${mRootPackageName}.${mActivityPackageName.replace("/", ".")}",
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false
        )

        //layout xml 文件名生成binding名
        var transActivityBinding = StringBuilder()
        mActivityLayoutName.split("_").onEach {
            var s = it.capitalize()
            transActivityBinding.append(s)
        }

        val mvvmActivity = mvvmActivityKt(
            mRootPackageName,
            mActivityPackageName.replace("/", "."),
            mPageName,
            transActivityBinding.toString(),
            mHasListWidget
        )

        // 保存Activity
        save(
            mvvmActivity,
            srcOut.resolve("${mActivityPackageName}/${mPageName}Activity.${ktOrJavaExt}")
        )
        if (mIsGenerateActivityLayout) {
            // 保存xml
            save(
                mvvmXml(mRootPackageName, mActivityPackageName, mPageName, mActivityLayoutName,mHasListWidget),
                resOut.resolve("layout/${mActivityLayoutName}.xml")
            )
        }
        // 保存viewmodel
        save(
            mvvmViewModelKt(mRootPackageName, mActivityPackageName.replace("/", "."), mPageName,mHasListWidget),
            srcOut.resolve("${mActivityPackageName}/${mPageName}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepositoryKt(mRootPackageName, mActivityPackageName.replace("/", "."), mPageName,mHasListWidget),
            srcOut.resolve("${mActivityPackageName}/${mPageName}Repository.${ktOrJavaExt}")
        )


        if (mHasListWidget) { //添加列表，则创建Adapter
            val mvvmAdapter = mvvmAdapterKt(
                mRootPackageName,
                mActivityPackageName.replace("/", "."),
                mPageName,
                transActivityBinding.toString(),
                mActivityLayoutName,
            )
            // 保存Adapter
            save(
                mvvmAdapter,
                srcOut.resolve("${mActivityPackageName}/${mPageName}Adapter.${ktOrJavaExt}")
            )

            // 保存list item xml
            save(
                mvvmItemXml(mRootPackageName, mActivityPackageName, mPageName),
                resOut.resolve("layout/${mActivityLayoutName}_item.xml")
            )
        }

    } else if (mIsFragment) {

        //layout xml 文件名生成binding名
        var transFragmentBinding = StringBuilder()
        mFragmentLayoutName.split("_").onEach {
            var s = it.capitalize()
            transFragmentBinding.append(s)
        }

        val mvvmFragment: String = mvvmFragmentKt(
                mRootPackageName,
                mFragmentPackageName.replace("/", "."),
                mPageName,
                transFragmentBinding.toString(),
                mHasListWidget
            )

        // 保存Fragment
        save(
            mvvmFragment,
            srcOut.resolve("${mFragmentPackageName}/${mPageName}Fragment.${ktOrJavaExt}")
        )
        if (mIsGenerateFragmentLayout) {
            // 保存xml
            save(
                mvvmXml(mRootPackageName, mFragmentPackageName, mPageName,mFragmentLayoutName,mHasListWidget),
                resOut.resolve("layout/${mFragmentLayoutName}.xml")
            )
        }
        // 保存viewmodel
        save(
            mvvmViewModelKt(mRootPackageName, mFragmentPackageName.replace("/", "."), mPageName,mHasListWidget),
            srcOut.resolve("${mFragmentPackageName}/${mPageName}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepositoryKt(mRootPackageName, mFragmentPackageName.replace("/", "."), mPageName,mHasListWidget),
            srcOut.resolve("${mFragmentPackageName}/${mPageName}Repository.${ktOrJavaExt}")
        )

        if (mHasListWidget) { //添加列表，则创建Adapter
            val mvvmAdapter = mvvmAdapterKt(
                mRootPackageName,
                mActivityPackageName.replace("/", "."),
                mPageName,
                transFragmentBinding.toString(),
                mFragmentLayoutName,
            )
            // 保存Adapter
            save(
                mvvmAdapter,
                srcOut.resolve("${mFragmentPackageName}/${mPageName}Adapter.${ktOrJavaExt}")
            )

            // 保存list item xml
            save(
                mvvmItemXml(mRootPackageName, mActivityPackageName, mPageName),
                resOut.resolve("layout/${mFragmentLayoutName}_item.xml")
            )
        }
    }
}