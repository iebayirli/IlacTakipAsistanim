package com.example.ilactakipasistanim.ui.main.medicines

import com.example.ilactakipasistanim.R
import com.example.ilactakipasistanim.ui.base.BaseFragment
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MedicinesFragment : BaseFragment<MedicinesPresenter>(), MedicinesContract.View {

    override val layoutId: Int = R.layout.fragment_medicines
    override val presenter: MedicinesPresenter by inject {
        parametersOf(this)
    }

    override fun initializeUI() {

    }
}