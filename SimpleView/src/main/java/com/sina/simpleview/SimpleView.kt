package com.sina.simpleview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmButtonStyle
import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmationBtmSheet
import com.sina.simpleview.btmsheetdialog.normal.SimpleBtmSheetFragment
import com.sina.simpleview.library.R

object SimpleView {
    val ConfirmationBtmSheet = ConfirmationBtmSheetFactory
    val NormalBtmSheet = CustomBtmSheetFactory
}

object CustomBtmSheetFactory {
    fun <B : ViewBinding> create(
        bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> B,
        setup: (B) -> Unit
    ): SimpleBtmSheetFragment<B> {
        val fragment = object : SimpleBtmSheetFragment<B>(bindingInflater) {
            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)
                setup(binding)
            }
        }
        return fragment
    }
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

