package com.sina.simpleviews

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sina.simpleview.SimpleView
import com.sina.simpleview.btmsheetdialog.confirmation.ConfirmButtonStyle
import com.sina.simpleview.library.databinding.DialogConfirmationBinding
import com.sina.simpleviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Initialize View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        SimpleView.ConfirmationBtmSheet.create(
//            context = this, // Pass requireContext() if in Fragment
//            message = "Do you want to delete this item?",
//            positiveText = "Delete",
//            negativeText = "Cancel",
//            style = ConfirmButtonStyle.ROUNDED,
//            buttonColor = Color.RED
//        ) {
//            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show()
//        }.show()

        binding.text.setOnClickListener {
            SimpleView.BtmSheet.create<DialogConfirmationBinding>(supportFragmentManager) {

            }.show(supportFragmentManager, "CustomBottomSheet")
        }

    }

}