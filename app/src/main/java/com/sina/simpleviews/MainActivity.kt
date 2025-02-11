package com.sina.simpleviews

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sina.simpleview.SimpleView
import com.sina.simpleview.library.databinding.DialogConfirmationBinding
import com.sina.simpleview.library.databinding.DialogSortFolderBinding
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
        binding.text.setOnClickListener {
            SimpleView.SimpleRadioGroupDialog.create<Sort, DialogSortFolderBinding>(this@MainActivity){binding,dialog,selectedSort->
                binding.radioGroup.removeAllViews()
                Sort.entries.forEach { sortOption ->
                    val radioButton = RadioButton(this).apply {
                        text = sortOption.name
                        id = View.generateViewId()
                        isChecked = sortOption == selectedSort
                    }
                    binding.radioGroup.addView(radioButton)

                    // ✅ Handle selection
                    radioButton.setOnClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "Selected: $sortOption", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.btnClose.setOnClickListener { dialog.dismiss() }
            }
        }
    }

}

enum class Sort{
    DATE,NAME,
}