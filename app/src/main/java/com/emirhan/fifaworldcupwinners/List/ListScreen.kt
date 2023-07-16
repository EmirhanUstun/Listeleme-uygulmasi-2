package com.h5210060_emirhan.ustun_final.Screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.emirhan.fifaworldcupwinners.Utils.AlertUtils
import com.h5210060_emirhan.ustun_final.List.Adapter
import com.emirhan.fifaworldcupwinners.Screen.DetailScreen
import com.h5210060_emirhan.ustun_final.R
import com.emirhan.fifaworldcupwinners.List.Veri
import com.h5210060_emirhan.ustun_final.databinding.ActivityListScreenBinding


enum class ListeTipi{
    LIST, GRID, STRAGGED
}

class ListScreen : AppCompatActivity() {

    private lateinit var binding: ActivityListScreenBinding
    private lateinit var adapter: Adapter

    val veri = Veri()
    val futbolcuListesi = veri.futbolcuListesiniAl()

    var varsayılanTip = ListeTipi.LIST

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_screen)
        init()

        binding.imgGrid.setOnClickListener {
            when (varsayılanTip) {
                ListeTipi.LIST -> {
                    varsayılanTip = ListeTipi.GRID
                }
                ListeTipi.GRID -> {
                    varsayılanTip = ListeTipi.STRAGGED
                }
                ListeTipi.STRAGGED -> {
                    varsayılanTip = ListeTipi.LIST
                }
            }
            initRecycleView(varsayılanTip)
        }
    }
    //'init' fonksiyonu, gerekli başlatma işlemlerini yapmak için kullanılır.
    // İçerisinde 'initBinding', 'initRecycleView' ve 'initSirala' fonksiyonları çağırılır.
    fun init() {
        initBinding()
        initRecycleView(varsayılanTip)
        initSirala()
    }

    //'initBinding' fonksiyonu, veri bağlamayı başlatmak için kullanılır.
    // ActivityListScreenBinding nesnesi oluşturur ve içeriği binding değişkenine atar.
    // Böylece layout bileşenlerine erişim sağlanır.
    fun initBinding() {
        binding = ActivityListScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    //'initRecycleView' fonksiyonu, RecyclerView'i başlatmak için kullanılır.
    // İlk olarak bir Adapter nesnesi oluşturulur ve futbolcuListesi verileriyle birlikte başlatılır.
    // Ardından, rcvFutbolcular adlı RecyclerView'e bu adaptör atanır ve görünüm düzeni belirtilir.
    // Görünüm düzeni, tip parametresine göre LinearLayoutManager, GridLayoutManager veya StaggeredGridLayoutManager olarak ayarlanır.
    private fun initRecycleView(tip: ListeTipi) {
        adapter = Adapter(futbolcuListesi) { futbolcu ->
            val intent = Intent(this@ListScreen, DetailScreen::class.java)
            intent.putExtra("futbolcuAdi", futbolcu.isim)
            intent.putExtra("futbolcuDetay", futbolcu.aciklama)
            startActivity(intent)
        }

        binding.rcvFutbolcular.adapter = adapter

        binding.rcvFutbolcular.layoutManager = when (tip) {
            ListeTipi.LIST -> LinearLayoutManager(this)
            ListeTipi.GRID -> GridLayoutManager(this, 2)
            ListeTipi.STRAGGED -> StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    // 'initSirala' fonksiyonu, sıralama işlemini başlatmak için kullanılır. btnSirala adlı bir butonun tıklamasını dinler.
    // Butona tıklandığında AlertUtils.secimGoster fonksiyonu çağırılır.
    // Bu fonksiyon, bir sıralama seçeneği seçmek için bir diyalog gösterir ve seçeneklere göre futbolcuListesi'ni sıralar ve adaptörü günceller.
    fun initSirala() {
        binding.btnSirala.setOnClickListener {
            AlertUtils.secimGoster(this@ListScreen) { siralama ->
                when (siralama) {
                    "İsme Göre Azalan" -> {
                        futbolcuListesi.sortByDescending { it.isim }
                        adapter.notifyDataSetChanged()
                    }
                    "İsme Göre Artan" -> {
                        futbolcuListesi.sortBy { it.isim }
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

}