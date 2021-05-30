package com.smendon.android.taxihub.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.smendon.android.taxihub.R

object MapUtils {
    fun getCabBitmap(context: Context): Bitmap {
        val bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.ic_cab)
        return Bitmap.createScaledBitmap(bitmap, 50, 100, false)
    }
}