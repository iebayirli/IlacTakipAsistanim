package com.example.ilactakipasistanim.ui.main.medicines.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.MedicinesClass
import com.example.ilactakipasistanim.utils.Utils
import kotlinx.android.synthetic.main.item_medicines_recycler_view.view.*

class MedicinesAdapter (var items : ArrayList<MedicinesClass>,
                        var activity : Activity,
                        private var itemClickListener : RecyclerViewItemClickListener):
RecyclerView.Adapter<MedicinesAdapter.MedicinedViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicinedViewHolder {
        var inflater  =LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.item_medicines_recycler_view,parent,false)
        return MedicinedViewHolder(
            view
        )
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MedicinedViewHolder, position: Int) {
        holder.bind(activity,items[position],itemClickListener,position)
    }





    class MedicinedViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        var ilacAdi = itemView.text_view_ilac_adi
        var kullanimSekli = itemView.text_view_kullanim_sekli
        var baslangicTarihi = itemView.text_view_baslangic_tarihi
        var kullanimSayisi = itemView.text_view_kullanım_adedi
        var muayeneYeri = itemView.text_view_muayene_yeri


        fun bind(
            activity: Activity,
            medicine : MedicinesClass,
            clickListener: RecyclerViewItemClickListener,
            index : Int
        ){
            if(medicine.isFromEnabiz){
                itemView.imageViewLogo.visibility = View.VISIBLE
                itemView.text_view_muayene_yeri.text = medicine.hastaneAdi

            }else{
                itemView.imageViewLogo.visibility= View.GONE
                itemView.text_view_muayene_yeri.text = "Yok."

            }
            Utils.calculateRowItemSize(itemView.root,activity)
            ilacAdi.text = medicine.ilacAdi
            kullanimSekli.text = medicine.kullanimSekli
            baslangicTarihi.text=medicine.baslangicTarihi
            kullanimSayisi.text=medicine.kullanimSayisi

            itemView.alarm_ekle_button.setOnClickListener {
                clickListener.onItemClicked(index , true)
            }
            itemView.ilaci_kaldir_button.setOnClickListener {
                clickListener.onItemClicked(index,false)
            }


        }
    }


}
interface RecyclerViewItemClickListener{
    fun onItemClicked(index : Int , isAddAlarm : Boolean)
}