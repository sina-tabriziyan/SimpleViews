/**
 * Created by ST on 2/11/2025.
 * Author: Sina Tabriziyan
 * @sina.tabriziyan@gmail.com
 */
package com.sina.simpleview.dialog

import android.content.Context
import android.content.DialogInterface
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding

object SimpleDialogFactory {
    inline fun <reified B : ViewBinding> create(
        context: Context,
        noinline setup: (B, DialogInterface) -> Unit
    ): SimpleDialogFragment<B> {
        return SimpleDialogFragment(B::class.java, setup).apply {
            show(context)
        }
    }
}
