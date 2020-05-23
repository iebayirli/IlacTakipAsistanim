package com.example.ilactakipasistanim.ui.main.alarms

import android.preference.DialogPreference
import com.example.ilactakipasistanim.ui.base.BasePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AlarmsPresenter(view : AlarmsContract.View): BasePresenter<AlarmsContract.View>(view),
            AlarmsContract.Presenter{

    override fun initList(isTrue: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            view?.initList(isTrue)
            withContext(Dispatchers.Main){
                view?.initRecyclerView()
            }
        }
    }

    override fun onAlarmDeleteClick(index: Int) {
        CoroutineScope(Dispatchers.IO).launch {
                view?.deleteAlarm(index)
        }
    }

    override fun alarmDeleted(index: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            view?.deleteAlarmFromListAndSaveShared(index)

            withContext(Dispatchers.Main){
                view?.initRecyclerView()
            }
        }
    }
}