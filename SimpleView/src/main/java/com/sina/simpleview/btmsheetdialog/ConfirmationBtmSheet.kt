/**
 * Created by st on 2/9/2025.
 * Author: Sina Tabriziyan
 * @sina.tabriziyan@gmail.com
 */
package com.sina.simpleview.btmsheetdialog

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.sina.simpleview.library.R
import com.sina.simpleview.library.databinding.DialogConfirmationBinding

class ConfirmationBtmSheet(
    context: Context,
    message: String,
    positiveText: String?,
    negativeText: String?,
    private val style: ConfirmButtonStyle = ConfirmButtonStyle.NORMAL,
    private val buttonColor: Int, // Accept color as an Int
    private val onConfirm: () -> Unit
) : BottomSheetDialog(context) {

    private val binding: DialogConfirmationBinding = DialogConfirmationBinding.inflate(LayoutInflater.from(context))

    private val defaultPositiveText = positiveText ?: context.getString(R.string.confirm)
    private val defaultNegativeText = negativeText ?: context.getString(R.string.cancel)

    init {
        setContentView(binding.root)

        binding.txtMessage.text = message
        binding.btnPositive.text = defaultPositiveText
        binding.btnNegative.text = defaultNegativeText

        applyButtonStyles()

        binding.btnPositive.setOnClickListener {
            onConfirm.invoke()
            dismiss()
        }

        binding.btnNegative.setOnClickListener { dismiss() }
    }

    private fun applyButtonStyles() {
        val backgroundDrawable = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            setColor(buttonColor) // Set color dynamically
            cornerRadius = if (style == ConfirmButtonStyle.ROUNDED) 50f else 8f // Rounded or normal
        }

        binding.btnPositive.background = backgroundDrawable
        binding.btnNegative.background = backgroundDrawable
    }
}
