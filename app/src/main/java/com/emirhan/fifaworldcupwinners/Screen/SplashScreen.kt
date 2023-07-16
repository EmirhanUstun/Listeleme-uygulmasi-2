package com.h5210060_emirhan.ustun_final.Screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.h5210060_emirhan.ustun_final.Extentions.ekranAc
import com.emirhan.fifaworldcupwinners.Utils.NetworkUtil
import com.h5210060_emirhan.ustun_final.R
import com.h5210060_emirhan.ustun_final.databinding.ActivityMainBinding


class SplashScreen : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    // Bu kod parçası diğer yöntemleri çağırır ve kod tekrarını önler.
    // 'init' fonksiyonu, gerekli başlatma işlemlerini yapmak için kullanılır.
    // 'initBinding' ve 'initCounterDown' fonksiyonlarını çağırır.
    fun init() {
        initBinding()
        initCounterDown()
    }

    // Bu kod parçası XML'deki ögelerli koda bağlamak için.
    // 'initBinding' fonksiyonu, veri bağlamayı başlatmak için kullanılır.
    // ActivityMainBinding nesnesi oluşturulur ve içeriği binding değişkenine atar.
    // Böylece layout bileşenlerine erişim sağlanır.
    fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // 'initCounterDown' fonksiyonu, geri sayım işlemini başlatmak için kullanılır.
    // CountDownTimer sınıfını kullanarak 4 saniyelik bir geri sayım başlatılır.
    fun initCounterDown() {
        // Bu kod parçası 5 saniyelik bir geri sayım işlemi yapar.
        object : CountDownTimer(4000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }
            //
            // 'onFinish' fonksiyonu, geri sayım tamamlandığında çağrılır.
            // ekranGecis fonksiyonunu çağırarak diğer bir ekrana geçişi başlatır.
            override fun onFinish() {
                ekranGecis()
            }
        }.start()
    }

    //
    // 'ekranGecis' fonksiyonu, geri sayım tamamlandığında gerçekleşen işlemleri içerir.
    // İlk olarak, progressBar2 adlı bir ilerleme çubuğunun görünürlüğünü kaldırır.
    // Ardından, internet bağlantısını kontrol eder.
    fun ekranGecis() {
        binding.progressBar2.visibility = View.GONE
        // Eğer internet bağlantısı varsa (NetworkUtil.isInternetAvaible fonksiyonu true döndürürse)
        // Aşağıdaki işlemler gerçekleşir ve SplashScreen ölür ve ListScreen e geçer.
        if (NetworkUtil.isInternetAvaible(applicationContext)){
            // Geri sayım bittiğinde ikinci ekrana geçmek için.
            ekranAc(ListScreen::class.java)
            Toast.makeText(applicationContext,"Internet Var", Toast.LENGTH_LONG).show()
            finish()
            //Eğer internet bağlantısı yoksa (NetworkUtil.isInternetAvaible fonksiyonu false döndürürse)
            // Aşağıdaki işlmelr gerçekleşir ve sizi internet ayarlarına yönlendirilir.
        } else {
            startActivity( Intent(
                Settings.ACTION_WIFI_SETTINGS)
            )
            Toast.makeText(applicationContext,"Internet Yok", Toast.LENGTH_LONG).show()
        }
    }
}
