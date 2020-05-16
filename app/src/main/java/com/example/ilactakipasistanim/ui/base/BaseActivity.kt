package com.example.ilactakipasistanim.ui.base

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager

abstract class BaseActivity<T : BasePresenter<*>>: AppCompatActivity(), BaseView {

    protected abstract val presenter: T
    protected abstract val layoutId: Int

    protected abstract fun initiliazeUI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        presenter.initialize(intent.extras)
        initiliazeUI()
    }

    override fun onStart() {
        super.onStart()
        presenter.start()
    }

    override fun onStop() {
        super.onStop()
        presenter.finalizeView()
    }

    override fun toast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    inline fun <reified E: BaseFragment<*>> navigateFragmentWithBackStack(layoutId: Int, vararg params: Pair<String, Any>, animation: Boolean?=false) {
        val fragment =  E::class.java.newInstance().apply {
            bundleOf(*params)
        }

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(layoutId, fragment, fragment::class.java.simpleName)
            .addToBackStack(fragment::class.java.simpleName)
            .commit()
    }


    inline fun <reified E: BaseFragment<*>> navigateFragmentAndClearBackStack(layoutId: Int, vararg params: Pair<String, Any>) {
        val fragment =  E::class.java.newInstance().apply {
            bundleOf(*params)
        }

        //clear backStack
        val fm = supportFragmentManager
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

        val transaction = fm.beginTransaction()
        transaction.replace(layoutId, fragment)
            .addToBackStack(fragment::class.java.simpleName)
        transaction.commit()
    }


    inline fun <reified E: BaseFragment<*>> navigateFragment(layoutId: Int, vararg params: Pair<String, Any>) {
        val fragment =  E::class.java.newInstance().apply {
            bundleOf(*params)
        }

        supportFragmentManager
            .beginTransaction()
            .replace(layoutId, fragment)
            .disallowAddToBackStack()
            .commit()
    }



}