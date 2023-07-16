package com.h5210060_emirhan.ustun_final.Extentions

import android.app.Activity
import android.content.Intent


// Bu kod parçası bir aktivitiden başka bir aktivitiye geçmek için kullanılır. Bu yöntem kod tekrarını önler.
fun Activity.ekranAc(yeniEkran: Class<*>) {
    initSecondActivity(this, yeniEkran)
}

fun initSecondActivity(activity: Activity, second: Class<*>) {
    activity.startActivity(Intent(activity, second))
    activity.finish()
}