package com.example.ilactakipasistanim.ui.main.alarms.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView

import androidx.recyclerview.widget.RecyclerView
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.AlarmsClass
import com.example.ilactakipasistanim.utils.Utils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_alarms_recycler.view.*

class AlarmsAdapter(var items : ArrayList<String>,
                    var activity: Activity,
                    private var alarmViewItemClickListener: AlarmViewItemClickListener):
    RecyclerView.Adapter<AlarmsAdapter.AlarmsViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmsViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var alarm = inflater.inflate(R.layout.item_alarms_recycler,parent,false)
        return AlarmsViewHolder(
            alarm
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: AlarmsViewHolder, position: Int) {
        holder.bind(activity,items[position],alarmViewItemClickListener,position)

    }

    class AlarmsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var ilacAdi = itemView.text_view_ilac_adi_alarm
        var kullanimSekli = itemView.text_view_kullanim_sekli_alarm
        var baslangicTarihi = itemView.text_view_baslangic_tarihi_alarm
        var kullanimAdedi = itemView.text_view_kullanım_adedi_alarm
        var alarmlar = itemView.text_view_alarm_saatleri

        fun bind(
            activity: Activity,
            medicine : String,
            clickListener: AlarmViewItemClickListener,
            index : Int
        ){
            var alarmMedicine = Gson().fromJson( medicine, AlarmsClass::class.java)

            if(alarmMedicine.medicine.isFromEnabiz){
                itemView.imageViewLogoAlarms.visibility=View.VISIBLE
            }else{
                itemView.imageViewLogoAlarms.visibility= View.GONE
            }
            Utils.calculateRowItemSize(itemView.rootAlarm,activity)
            ilacAdi.text = alarmMedicine.medicine.ilacAdi
            kullanimSekli.text = alarmMedicine.medicine.kullanimSekli
            baslangicTarihi.text = alarmMedicine.medicine.baslangicTarihi
            kullanimAdedi.text = alarmMedicine.medicine.kullanimSayisi

            var tmp = ""
            alarmMedicine.alarmSaatleri.forEach {
                tmp = tmp + " " + it
            }
            alarmlar.text=tmp

            itemView.alarm_sil_button.setOnClickListener {
                clickListener.onAlarmClicked(index)
            }
        }

    }
}
interface AlarmViewItemClickListener{
    fun onAlarmClicked(index : Int)
}