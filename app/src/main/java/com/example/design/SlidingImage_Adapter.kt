package com.example.design

import android.os.Parcelable
import android.content.Context
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter


class SlidingImage_Adapter(private val context: Context, private val IMAGES: ArrayList<Int>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    private val inflater: LayoutInflater = LayoutInflater.from(context)


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return IMAGES.size
    }

    override fun instantiateItem(view: ViewGroup, position: Int): Any {
        val imageLayout = inflater.inflate(R.layout.slider_view, view, false)!!

        val imageView = imageLayout!!
            .findViewById(R.id.image) as ImageView


        imageView.setImageResource(IMAGES[position])

        view.addView(imageLayout, 0)

        return imageLayout
    }

    override fun restoreState(state: Parcelable?, loader: ClassLoader?) {}

    override fun saveState(): Parcelable? {
        return null
    }


}