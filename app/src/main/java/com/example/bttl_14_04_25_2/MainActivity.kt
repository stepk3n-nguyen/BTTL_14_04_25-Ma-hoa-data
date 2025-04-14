package com.example.bttl_14_04_25_2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editInput: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        editInput = findViewById(R.id.editInput)
        radioGroup = findViewById(R.id.radioGroup)
        textResult = findViewById(R.id.textResult)

        // Theo dõi thay đổi nội dung nhập
        editInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = encode()
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        // Theo dõi thay đổi lựa chọn
        radioGroup.setOnCheckedChangeListener { _, _ -> encode() }
    }

    private fun encode() {
        val input = editInput.text.toString()
        val selectedId = radioGroup.checkedRadioButtonId

        val result = when (selectedId) {
            R.id.radioUpper -> input.uppercase()
            R.id.radioLower -> input.lowercase()
            R.id.radioReverse -> input.reversed()
            else -> ""
        }

        textResult.text = "Kết quả: $result"
    }
}