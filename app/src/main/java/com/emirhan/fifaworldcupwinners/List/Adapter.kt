package com.h5210060_emirhan.ustun_final.List

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.h5210060_emirhan.ustun_final.databinding.ChampionsItemListBinding

//Adapter sınıfı, RecyclerView.Adapter sınıfını genişletir ve içinde bir iç sınıf olan ViewHolder'ı tanımlar.
// Ayrıca, bir futbolcu listesi ve bir tıklama olayı (lambda ifadesi) alır.
class Adapter(var futbolcuListesi: ArrayList<Futbolcu>, var onClik: (Futbolcu) -> Unit) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    //ViewHolder sınıfı, RecyclerView'da her bir öğeyi temsil eden görünüm öğelerini ve olayları tanımlar.
    // ChampionsItemListBinding veri bağlama sınıfından türetilmiş bir binding nesnesi içerir.
    //imgFutbolcu değişkeni, futbolcu resminin görüntülendiği ImageView'i temsil eder.
    //bind fonksiyonu, futbolcu verilerini bağlar ve ilgili görünüme atar
    // . Resim Glide kütüphanesi kullanılarak yüklenir.
    // Ayrıca, bir kart görünümüne tıklama olayını dinler ve lambda ifadesi aracılığıyla tıklanan futbolcu öğesini döndürür.
    inner class ViewHolder(val binding: ChampionsItemListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val imgFutbolcu = binding.imgUser

        fun bind(futbolcu: Futbolcu) {
            binding.apply {
                txtIsim.text = futbolcu.isim
                txtExplanation.text = futbolcu.aciklama

                Glide.with(itemView)
                    .load(futbolcu.resimUrl)
                    .into(imgFutbolcu)

                cardView.setOnClickListener {
                    onClik(futbolcu)
                }
            }
        }
    }

    //onCreateViewHolder fonksiyonu, görünüm öğelerini oluşturmak için kullanılır.
    // ChampionsItemListBinding kullanarak bir görünüm bağlama nesnesi oluşturulur ve bu nesne bir ViewHolder'a atanır.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ChampionsItemListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    //getItemCount fonksiyonu, adaptördeki futbolcu listesinin boyutunu döndürür.
    override fun getItemCount(): Int {
        return futbolcuListesi.size
    }

    //onBindViewHolder fonksiyonu, verileri görünümlere bağlamak için kullanılır.
    // Belirli bir konumdaki futbolcu öğesini alır ve ilgili ViewHolder'a bağlama işlemini gerçekleştirir.
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val futbolcu = futbolcuListesi[position]
        holder.bind(futbolcu)
    }
}
