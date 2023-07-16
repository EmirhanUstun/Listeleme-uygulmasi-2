package com.emirhan.fifaworldcupwinners.Utils

import android.app.Activity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

object AlertUtils {
    fun secimGoster(activity: Activity, onSecim: (String) -> Unit) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("Sırala")

        val siralama = arrayOf("İsme Göre Azalan", "İsme Göre Artan")
        builder.setItems(siralama) { dialog, pozisyon ->
            val secim = siralama[pozisyon]
            onSecim(secim)
        }

        builder.setNegativeButton("Çık") { dialog, i ->
            dialog.dismiss()
        }
        builder.show()
    }
}