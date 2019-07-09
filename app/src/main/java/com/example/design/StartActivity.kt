package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_start.*
import java.util.concurrent.TimeUnit

class StartActivity : AppCompatActivity() {

    private val IMAGES = arrayOf(R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo)
    private val ImagesArray = ArrayList<Int>()
    private var imageViewDot: Array<ImageView?>? = null
    val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        imageViewDot = arrayOfNulls(size = 4)
        for (i in 0..3) {
            ImagesArray.add(IMAGES[i])
        }

        val adapter = SlidingImage_Adapter(this@StartActivity, ImagesArray)
        viewPagerImage.adapter = adapter

        for (i in 0..3) {
            imageViewDot!![i] = ImageView(this)
            imageViewDot!![i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.non_active_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.setMargins(8, 0, 8, 0)

            linearLayoutSlideDot.addView(imageViewDot!![i], params)
        }
        imageViewDot!![0]!!.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.active_dot))
        startSlider()

        textViewAlready.setOnClickListener {
            startActivity(Intent(this@StartActivity, AlreadyWalletActivity::class.java))
        }
        buttonNewWallet.setOnClickListener {
            startActivity(Intent(this@StartActivity, CreateWallterPreviewActivity::class.java))
        }
    }

    private fun startSlider() {
        val subscribe = Observable.interval(5, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                if (viewPagerImage.currentItem < viewPagerImage.adapter!!.count - 1) {
                    viewPagerImage.currentItem = viewPagerImage.currentItem + 1
                } else {
                    viewPagerImage.currentItem = 0
                }
            }
        compositeDisposable.add(subscribe)
    }
}
