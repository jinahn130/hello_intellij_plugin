package com.example.hello

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.command.WriteCommandAction

class InsertHelloAction : AnAction("Insert Hello", "Insert text at caret", null) {

    override fun actionPerformed(e: AnActionEvent) {
        val project = e.project ?: return
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val document = editor.document
        val caret = editor.caretModel.currentCaret

        WriteCommandAction.runWriteCommandAction(project) {
            document.insertString(caret.offset, "Hello, world!")
        }
    }

    override fun update(e: AnActionEvent) {
        e.presentation.isEnabledAndVisible = e.getData(CommonDataKeys.EDITOR) != null
    }
}
