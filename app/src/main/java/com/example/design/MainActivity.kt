package com.example.design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.FragmentTransaction
import com.example.design.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mBottomSheetDialog: BottomSheetDialog? = null
    private var bottom_navigation: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation = findViewById(R.id.bottom_navigation)

        mainTitle.visibility = View.GONE
        textViewCollection.visibility = View.VISIBLE
        textViewToken.visibility = View.VISIBLE
        imageViewWallet.visibility = View.VISIBLE
        imageViewPlus.visibility = View.VISIBLE
        relativeSearch.visibility = View.GONE

        textViewToken.setTextColor(resources.getColor(R.color.colorWhite))
        textViewCollection.setTextColor(resources.getColor(R.color.colorText))
        supportFragmentManager.beginTransaction().replace(R.id.container, TokenFragment()).commit()

        textViewToken.setOnClickListener {
            imageViewWallet.visibility = View.VISIBLE
            imageViewPlus.visibility = View.VISIBLE
            textViewToken.setTextColor(resources.getColor(R.color.colorWhite))
            textViewCollection.setTextColor(resources.getColor(R.color.colorText))
            supportFragmentManager.beginTransaction().replace(R.id.container, TokenFragment()).commit()
        }

        textViewCollection.setOnClickListener {
            imageViewWallet.visibility = View.GONE
            imageViewPlus.visibility = View.GONE
            textViewToken.setTextColor(resources.getColor(R.color.colorText))
            textViewCollection.setTextColor(resources.getColor(R.color.colorWhite))
            supportFragmentManager.beginTransaction().replace(R.id.container, CollectionFragment()).commit()
        }

        imageViewWallet.setOnClickListener {
            showBottomSheet()
        }

        bottom_navigation?.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_wallet -> {
                    mainTitle.visibility = View.GONE
                    textViewCollection.visibility = View.VISIBLE
                    textViewToken.visibility = View.VISIBLE
                    imageViewWallet.visibility = View.VISIBLE
                    imageViewPlus.visibility = View.VISIBLE
                    relativeSearch.visibility = View.GONE

                    textViewToken.setTextColor(resources.getColor(R.color.colorWhite))
                    textViewCollection.setTextColor(resources.getColor(R.color.colorText))
                    supportFragmentManager.beginTransaction().replace(R.id.container, TokenFragment()).commit()
                }
                R.id.nav_dapp -> {
                    mainTitle.visibility = View.GONE
                    textViewCollection.visibility = View.GONE
                    textViewToken.visibility = View.GONE
                    imageViewWallet.visibility = View.GONE
                    imageViewPlus.visibility = View.GONE
                    relativeSearch.visibility = View.VISIBLE
                    supportFragmentManager.beginTransaction().replace(R.id.container, DAppFragment()).commit()
                }
                R.id.nav_dex -> {
                    mainTitle.visibility = View.VISIBLE
                    mainTitle.text = "Binance DEX"
                    textViewCollection.visibility = View.GONE
                    textViewToken.visibility = View.GONE
                    imageViewWallet.visibility = View.GONE
                    imageViewPlus.visibility = View.GONE
                    relativeSearch.visibility = View.GONE
                    supportFragmentManager.beginTransaction().replace(R.id.container, DexFragment()).commit()
                }
                R.id.nav_setting -> {
                    mainTitle.visibility = View.VISIBLE
                    mainTitle.text = "Settings"
                    textViewCollection.visibility = View.GONE
                    textViewToken.visibility = View.GONE
                    imageViewWallet.visibility = View.GONE
                    imageViewPlus.visibility = View.GONE
                    relativeSearch.visibility = View.GONE
                    supportFragmentManager.beginTransaction().replace(R.id.container, SettingFragment()).commit()
                }
            }
            true
        }
    }

    private fun showBottomSheet() {
        if (mBottomSheetDialog == null) {
            mBottomSheetDialog = BottomSheetDialog(this)
            val menuView = layoutInflater.inflate(R.layout.bottom_sheet_variant, null)
            mBottomSheetDialog!!.setContentView(menuView)
        }
        mBottomSheetDialog?.show()
    }
}
