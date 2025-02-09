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
    val ConfirmationBtmSheet = ConfirmationBtmSheetFactory
}

object ConfirmationBtmSheetFactory {
    fun create(
        context: Context,
        message: String,
        positiveText: String? = null,
        negativeText: String? = null,
        style: ConfirmButtonStyle = ConfirmButtonStyle.NORMAL,
        buttonColor: Int,
        onConfirm: () -> Unit
    ): ConfirmationBtmSheet {
        return ConfirmationBtmSheet(
            context = context,
            message = message,
            positiveText = positiveText ?: context.getString(R.string.confirm),
            negativeText = negativeText ?: context.getString(R.string.cancel),
            style = style,
            buttonColor = buttonColor,
            onConfirm = onConfirm
        )
    }
}

