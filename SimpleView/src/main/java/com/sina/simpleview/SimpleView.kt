package com.sina.simpleview

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sina.extensionview.ViewExtensions
import com.sina.simpleview.btmsheetdialog.ConfirmButtonStyle
import com.sina.simpleview.btmsheetdialog.ConfirmationBtmSheet
import com.sina.simpleview.library.R
import com.sina.simpleview.library.databinding.DialogConfirmationBinding

object SimpleView {
    val Extensions = ViewExtensions
    fun ConfirmationBtmSheet(
        context: Context,
        message: String,
        positiveText: String = context.getString(android.R.string.ok),
        negativeText: String = context.getString(android.R.string.cancel),
        style: ConfirmButtonStyle = ConfirmButtonStyle.NORMAL,
        buttonColor: Int,
        onConfirm: () -> Unit
    ): ConfirmationBtmSheet {
        return ConfirmationBtmSheet(
            context = context,
            message = message,
            positiveText = positiveText,
            negativeText = negativeText,
            style = style,
            buttonColor = buttonColor,
            onConfirm = onConfirm
        )
    }
}