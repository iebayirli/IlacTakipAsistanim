package com.example.ilactakipasistanim.ui.main.medicines

import android.app.Dialog
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.common.MedicinesClass
import com.example.ilactakipasistanim.common.SharedPrefKey
import com.example.ilactakipasistanim.ui.base.BaseFragment
import com.example.ilactakipasistanim.ui.main.medicines.adapter.MedicinesAdapter
import com.example.ilactakipasistanim.ui.main.medicines.adapter.RecyclerViewItemClickListener
import kotlinx.android.synthetic.main.fragment_medicines.*
import kotlinx.android.synthetic.main.item_add_medicines.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import java.util.*

class MedicinesFragment : BaseFragment<MedicinesPresenter>(), MedicinesContract.View , RecyclerViewItemClickListener {

    override val layoutId: Int = R.layout.fragment_medicines
    override val presenter: MedicinesPresenter by inject {
        parametersOf(this)
    }

    private var manuelAddedMedicines = ArrayList<MedicinesClass>()
    lateinit var  dialog : Dialog
    override fun initializeUI() {


        medicines_recycler_view.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)

        initDialog()

        ilac_ekle_button.setOnClickListener {
            dialog.show()

            dialog.ilac_ekle_onay_button.setOnClickListener {

                var ilacAdi = dialog.edit_text_ilac_adi.text.toString()
                var kullanimSekli = dialog.edit_text_kullanım_sekli.text.toString()
                var baslangicTarihi = dialog.edit_text_tarih.text.toString()
                var kullanimAdedi = dialog.edit_text_kullanım_adedi.text.toString()

                presenter.inputControl(ilacAdi,kullanimSekli,baslangicTarihi,kullanimAdedi)

            }

            dialog.close_window.setOnClickListener {
                dialog.dismiss()
            }
            dialog.ilac_ekle_iptal_button.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
    private fun initDialog(){
        dialog = Dialog(context,android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        var view = layoutInflater.inflate(R.layout.item_add_medicines,null)
        dialog.setContentView(view)
        dialog.window.setBackgroundDrawableResource(R.color.transparent)

        var ilkIlac = baseActivity?.sharedPrefHelper?.getBoolean(SharedPrefKey.ILK_ILAC)?:false
        if(ilkIlac){
            manuelAddedMedicines = baseActivity?.sharedPrefHelper?.getManuelMedicines(SharedPrefKey.MANUEL_ADD_MEDICINES)!!
            initRecyclerView()
        }else{
            initRecyclerView()
        }

    }
    private fun initRecyclerView(){

        if(manuelAddedMedicines.isNullOrEmpty()){
            ilaciniz_bulunmamakta.visibility= View.VISIBLE
            ilaciniz_bulunmamakta.text = "Kayıtlı İlacınız Bulunmamakta."
        }else{
            ilaciniz_bulunmamakta.visibility= View.GONE
            var adapter = MedicinesAdapter(manuelAddedMedicines,baseActivity!!,this)
            medicines_recycler_view.adapter = adapter
        }
    }

    override fun saveManuelAddedMedicines(
        ilacAdi: String,
        kullanimSekli: String,
        baslangicTarihi: String,
        kullanımAdedi: String
    ) {
        manuelAddedMedicines.add(MedicinesClass(ilacAdi,kullanimSekli,baslangicTarihi,kullanımAdedi,true))
        initRecyclerView()
    }

    override fun succeedDismissDialog() {
        dialog.dismiss()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        saveListFromShared()
    }
    private fun saveListFromShared(){
        baseActivity?.sharedPrefHelper?.saveManuelMedicines(SharedPrefKey.MANUEL_ADD_MEDICINES,manuelAddedMedicines)
        baseActivity?.sharedPrefHelper?.saveBoolean(SharedPrefKey.ILK_ILAC,true)
    }

    override fun onItemClicked(medicine: MedicinesClass) {
        toast(medicine.ilacAdi)
    }
}