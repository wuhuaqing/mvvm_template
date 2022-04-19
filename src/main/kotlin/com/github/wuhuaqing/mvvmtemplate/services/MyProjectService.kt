package com.github.wuhuaqing.mvvmtemplate.services

import com.intellij.openapi.project.Project
import com.github.wuhuaqing.mvvmtemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
