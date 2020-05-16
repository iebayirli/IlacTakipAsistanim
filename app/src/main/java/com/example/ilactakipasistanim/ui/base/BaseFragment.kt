package com.example.ilactakipasistanim.ui.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


abstract class BaseFragment<T: BasePresenter<*>>: Fragment(), BaseView {

    abstract  val layoutId: Int
    protected abstract val presenter: T
    private var baseActivity: BaseActivity<*>? = null

    abstract fun initializeUI()
    
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*>){
            baseActivity = context
        }
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.initialize(arguments)
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeUI()
    }

    override fun onDestroyView() {
        presenter.finalizeView()
        super.onDestroyView()
    }

    override fun toast(message: String) {
        baseActivity?.toast(message)
    }
}