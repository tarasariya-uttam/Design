package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import android.content.Intent
import android.os.Handler
import android.view.Menu
import androidx.core.os.HandlerCompat.postDelayed


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val mainIntent = Intent(this@SplashActivity, StartActivity::class.java)
            this@SplashActivity.startActivity(mainIntent)
            this@SplashActivity.finish()
        }, 2 * 1000)
    }
}
