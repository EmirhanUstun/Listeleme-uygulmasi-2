package com.emirhan.fifaworldcupwinners.Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.h5210060_emirhan.ustun_final.R
import com.emirhan.fifaworldcupwinners.List.Veri
import com.h5210060_emirhan.ustun_final.databinding.ActivityDetailScreenBinding


class DetailScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDetailScreenBinding
    private lateinit var futbolcuAdi: String
    private lateinit var aciklama: String
    private lateinit var futbolcuResim: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // DetailVeri sınıfından verileri alma
        val veri = Veri()
        val futbolcuListesi = veri.futbolcuListesiniAl()

        init()
    }

    fun init(){
        initBinding()
        initVeriAlma()
        initVeriGoster()
        initResimGoster()
    }

    // Bu kod parçası XML'deki ögelerli koda bağlamak için.
    //  'initBinding' fonksiyonu, binding değişkenine ActivityDetailScreenBinding.
    //  'inflate' yöntemi kullanılarak şişirilen görünüm kökünü atar ve ekrana ayarlar.
    fun initBinding() {
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // 'initVeriAlma' fonksiyonu, Intent aracılığıyla geçirilen futbolcu adı, açıklama ve resim verilerini ilgili değişkenlere atar.
    fun initVeriAlma() {
        futbolcuAdi = intent.getStringExtra("futbolcuAdi").toString()
        aciklama = intent.getStringExtra("futbolcuDetay").toString()
        futbolcuResim = intent.getStringExtra("futbolcuResim").toString()
    }

    // initVeriGoster fonksiyonu, futbolcu adını ve açıklamayı göstermek için ilgili görünümleri kullanır.
    // Bu görünümler binding değişkeni ile erişilir
    fun initVeriGoster() {
        binding.detailName.text = futbolcuAdi
        binding.detailDetay.text = aciklama
    }
    // 'initResimGoster' fonksiyonu, Glide kütüphanesini kullanarak futbolcu resmini yükler ve gösterir.
    // Glide.with(this) ifadesi, Glide kütüphanesini bu aktivite bağlamında başlatır ve resim yükleme işlemi için bir builder nesnesi oluşturur.
    // '.load'(futbolcuResim) ifadesi, Glide'a yüklemesi için futbolcu resim URL'sini belirtir. .placeholder(R.drawable.user_svg) ifadesi, resim yüklenene kadar görüntülenecek yer tutucu bir görüntüyü belirtir.
    // '.into'(binding.detailImage) ifadesi, yüklenen resmi binding.detailImage ImageView'ına yerleştirir.
    fun initResimGoster() {
        Glide.with(this)
            .load(futbolcuResim)
            .placeholder(R.drawable.user_svg)
            .into(binding.detailImage)
    }
}