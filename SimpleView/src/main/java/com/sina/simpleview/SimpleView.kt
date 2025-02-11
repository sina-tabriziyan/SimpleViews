package com.sina.simpleview

import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmationBtmSheetFactory
import com.sina.simpleview.btmsheetdialog.normal.BtmSheetFactory
import com.sina.simpleview.dialog.factory.SimpleDialogFactory
import com.sina.simpleview.dialog.factory.SimpleRadioGroupFactory

object SimpleView {
    val ConfirmationBtmSheet = ConfirmationBtmSheetFactory
    val SimpleBtmSheet = BtmSheetFactory
    val SimpleDialog = SimpleDialogFactory
    val SimpleRadioGroupDialog = SimpleRadioGroupFactory
}

