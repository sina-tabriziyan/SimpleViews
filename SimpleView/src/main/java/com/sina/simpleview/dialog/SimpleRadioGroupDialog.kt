/**
 * Created by ST on 2/11/2025.
 * Author: Sina Tabriziyan
 * @sina.tabriziyan@gmail.com
 */
package com.sina.simpleview.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewbinding.ViewBinding

class SimpleRadioGroupDialog<T : Enum<T>, B : ViewBinding>(
    private val bindingInflater: (LayoutInflater) -> B,
    private val enumValues: Array<T>,
    private val selectedItem: T?,
    private val setup: (binding: B, dialog: Dialog, selectedItem: T) -> Unit
) : DialogFragment() {

    private var _binding: B? = null
    protected val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        val inflater = LayoutInflater.from(requireContext())

        // ✅ Auto-Inflate ViewBinding
        _binding = bindingInflater(inflater)
        dialog.setContentView(binding!!.root)

        // ✅ Apply setup function
        setup(binding!!, dialog, selectedItem ?: enumValues.first())

        return dialog
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun show(context: Context) {
        val fragmentManager = when (context) {
            is FragmentActivity -> context.supportFragmentManager
            is Fragment -> context.parentFragmentManager
            else -> throw IllegalArgumentException("Context must be an instance of FragmentActivity or Fragment")
        }
        show(fragmentManager, "SimpleRadioGroupDialog")
    }
}




