package com.github.wuhuaqing.mvvm.common.res.layout

fun mvvmXml(
    mRootPackageName: String,
    mActivityPackageName: String,
    mPageName: String,
    mActivityLayoutName:String,
    mHasListWidget: Boolean,
): String {
    return if (mHasListWidget) {
        """
<?xml version="1.0" encoding="utf-8"?>

<layout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools">
  <data>
    <variable
      name="viewModel"
      type="${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel" />
  </data>

<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    <com.scwang.smart.refresh.layout.SmartRefreshLayout
      android:id="@+id/refresh_layout"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      app:layout_constraintLeft_toLeftOf="parent"
      app:layout_constraintRight_toRightOf="parent"
      app:layout_constraintTop_toTopOf="parent"
      app:layout_constraintBottom_toBottomOf="parent"
      android:layout_weight="1">

      <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        tools:listitem="@layout/${mActivityLayoutName}_item" />
    </com.scwang.smart.refresh.layout.SmartRefreshLayout>
    
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
    } else {
        """
<?xml version="1.0" encoding="utf-8"?>

<layout xmlns:android="http://schemas.android.com/apk/res/android"
  xmlns:app="http://schemas.android.com/apk/res-auto"
  xmlns:tools="http://schemas.android.com/tools">
  <data>
    <variable
      name="viewModel"
      type="${mRootPackageName}.${mActivityPackageName}.${mPageName}ViewModel" />
  </data>

<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    
    
</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
"""
    }
}
