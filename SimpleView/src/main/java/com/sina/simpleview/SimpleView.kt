package com.sina.simpleview

import android.content.Context
import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmButtonStyle
import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmationBtmSheet
import com.sina.simpleview.library.R

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

