package com.github.wuhuaqing.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import com.github.wuhuaqing.mvvm.activity.src.app_package.ui.mvvmActivityKt
import com.github.wuhuaqing.mvvm.common.repository.mvvmRepositoryKt
import com.github.wuhuaqing.mvvm.common.res.layout.mvvmXml
import com.github.wuhuaqing.mvvm.common.viewmodel.mvvmViewModelKt
import com.github.wuhuaqing.mvvm.activity.src.app_package.ui.mvvmFragmentKt
import com.github.wuhuaqing.mvvm.activity.src.app_package.ui.mvvmLazyFragmentKt

fun RecipeExecutor.mvvmActivityRecipe(
    moduleTemplateData: ModuleTemplateData,
    mRootPackageName: String,
    mPageName: String,
    mIsActivity: Boolean,
    mActivityLayoutName: String,
    mIsGenerateActivityLayout: Boolean,
    mActivityPackageName: String,
    mIsUseHilt: Boolean,
    mIsFragment :Boolean,
    mIsLazyFragment : Boolean,
    mFragmentLayoutName : String,
    mIsGenerateFragmentLayout : Boolean,
    mFragmentPackageName : String
) {
    val (projectData, srcOut, resOut) = moduleTemplateData
    val ktOrJavaExt = projectData.language.extension



    if (mIsActivity) {

        generateManifest(
            moduleData = moduleTemplateData,
            activityClass = "${mPageName}Activity",
            packageName = ".${mActivityPackageName.replace("/",".")}",
            isLauncher = false,
            hasNoActionBar = false,
            generateActivityTitle = false
        )

        val mvvmActivity = mvvmActivityKt(mRootPackageName, mActivityPackageName.replace("/","."), mPageName)
        // 保存Activity
        save(
            mvvmActivity,
            srcOut.resolve("${mActivityPackageName}/${mPageName}Activity.${ktOrJavaExt}")
        )
        if (mIsGenerateActivityLayout) {
            // 保存xml
            save(mvvmXml(mRootPackageName,mRootPackageName), resOut.resolve("layout/${mActivityLayoutName}.xml"))
        }
        // 保存viewmodel
        save(
            mvvmViewModelKt(mRootPackageName, mActivityPackageName.replace("/","."), mPageName),
            srcOut.resolve("${mActivityPackageName}/${mPageName}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepositoryKt(mRootPackageName, mActivityPackageName.replace("/","."), mPageName),
            srcOut.resolve("${mActivityPackageName}/${mPageName}Repository.${ktOrJavaExt}")
        )
    } else if (mIsFragment){
        val mvvmFragment: String = if (mIsLazyFragment) {

            mvvmLazyFragmentKt(mRootPackageName, mFragmentPackageName.replace("/","."), mPageName)
        } else {
            mvvmFragmentKt(mRootPackageName, mFragmentPackageName.replace("/","."), mPageName)
        }

        // 保存Fragment
        save(
            mvvmFragment,
            srcOut.resolve("${mFragmentPackageName}/${mPageName}Fragment.${ktOrJavaExt}")
        )
        if (mIsGenerateFragmentLayout) {
            // 保存xml
            save(mvvmXml(mRootPackageName,mRootPackageName), resOut.resolve("layout/${mFragmentLayoutName}.xml"))
        }
        // 保存viewmodel
        save(
            mvvmViewModelKt(mRootPackageName, mFragmentPackageName.replace("/","."), mPageName),
            srcOut.resolve("${mFragmentPackageName}/${mPageName}ViewModel.${ktOrJavaExt}")
        )
        // 保存repository
        save(
            mvvmRepositoryKt(mRootPackageName, mFragmentPackageName.replace("/","."), mPageName),
            srcOut.resolve("${mFragmentPackageName}/${mPageName}Repository.${ktOrJavaExt}")
        )
    }
}