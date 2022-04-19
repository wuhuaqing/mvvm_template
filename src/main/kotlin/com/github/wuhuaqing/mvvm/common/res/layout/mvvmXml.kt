package com.github.wuhuaqing.mvvm.common.res.layout

fun mvvmXml( mRootPackageName:String,
             mPageName:String)="""
<?xml version="1.0" encoding="utf-8"?>

<layout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools">
  <data>
    <variable
      name="viewModel"
      type="${mRootPackageName}.${mPageName}ViewModel" />
  </data>

<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
