package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_wallter_preview.*

class CreateWallterPreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_wallter_preview)
        checkBoxCondition.isChecked = false
        textViewContinue.setBackgroundColor(resources.getColor(R.color.colorGrey))
        textViewContinue.setTextColor(resources.getColor(R.color.colorText))
        textViewContinue.isEnabled = false
        checkBoxCondition?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                textViewContinue.setBackgroundColor(resources.getColor(R.color.colorPrimary))
                textViewContinue.setTextColor(resources.getColor(R.color.colorWhite))
                textViewContinue.isEnabled = true
            } else {
                textViewContinue.setBackgroundColor(resources.getColor(R.color.colorGrey))
                textViewContinue.setTextColor(resources.getColor(R.color.colorText))
                textViewContinue.isEnabled = false
            }
        }
        textViewContinue.setOnClickListener {
            startActivity(Intent(this@CreateWallterPreviewActivity, MainActivity::class.java))
        }
    }
}
