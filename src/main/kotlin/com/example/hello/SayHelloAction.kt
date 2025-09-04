package com.example.hello

import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

class SayHelloAction : AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val project: Project? = e.project
        val editor = e.getData(CommonDataKeys.EDITOR)
        val caretInfo = editor?.caretModel?.currentCaret?.let {
            " at line ${it.logicalPosition.line + 1}, column ${it.logicalPosition.column + 1}"
        } ?: ""

        val appSvc = service<MyAppService>()
        val projSvcText = project?.service<MyProjectService>()?.projectName()?.let { " (project: $it)" } ?: ""

        notify(project, "Hello from your plugin$caretInfo — ${appSvc.greet()}$projSvcText")
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.project != null
    }

    private fun notify(project: Project?, message: String) {
        NotificationGroupManager.getInstance()
            .getNotificationGroup("hello.notifications")
            .createNotification(message, NotificationType.INFORMATION)
            .notify(project)
    }
}
