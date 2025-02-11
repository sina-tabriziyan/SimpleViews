/**
 * Created by ST on 2/11/2025.
 * Author: Sina Tabriziyan
 * @sina.tabriziyan@gmail.com
 */
package com.sina.simpleview.dialog.factory

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.sina.simpleview.dialog.SimpleRadioGroupDialog

object SimpleRadioGroupFactory {
    inline fun <reified T : Enum<T>, reified B : ViewBinding> create(
        context: Context,
        noinline bindingInflater: (LayoutInflater) -> B,
        selectedItem: T? = null,
        noinline setup: (binding: B, dialog: Dialog, selectedItem: T) -> Unit
    ) {
        val dialog = SimpleRadioGroupDialog(
            bindingInflater = bindingInflater,  // ✅ Pass bindingInflater correctly
            enumValues = enumValues(),
            selectedItem = selectedItem,
            setup = setup
        )
        dialog.show(context) // ✅ Ensure dialog is properly shown
    }
}
