package com.sina.simpleview

import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmationBtmSheetFactory
import com.sina.simpleview.btmsheetdialog.normal.BtmSheetFactory
import com.sina.simpleview.dialog.SimpleDialogFactory
import com.sina.simpleview.dialog.SimpleRadioGroupFactory

object SimpleView {
    val ConfirmationBtmSheet = ConfirmationBtmSheetFactory
    val SimpleBtmSheetFragment = BtmSheetFactory
    val SimpleDialogFragment = SimpleDialogFactory
    val SimpleRadioGroup = SimpleRadioGroupFactory
}

