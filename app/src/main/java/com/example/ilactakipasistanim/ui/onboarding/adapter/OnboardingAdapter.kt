package com.example.ilactakipasistanim.ui.onboarding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ilactakipasistanim.R
import kotlinx.android.synthetic.main.item_onboarding.view.*


data class OnboardingData (val title: String, val desc: String, val imageUrl: Int, val isBg: Boolean = true )

class OnboardingAdapter(val items : List<OnboardingData>): RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>(){





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_onboarding,parent,false)
            return OnboardingViewHolder(
                view
            )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {

        val item =items[position]
            if(position == 0 ){
                holder.itemView.onboarding_text_1.visibility=View.VISIBLE
                holder.itemView.onboarding_text_2.visibility=View.VISIBLE
                holder.itemView.onboarding_text_3.visibility=View.GONE
                holder.itemView.guideline2.setGuidelinePercent(0.3f)
                holder.itemView.guideline5.setGuidelinePercent(0.7f)

                holder.itemView.onboarding_text_1.text=item.title
                holder.itemView.onboarding_text_2.text=item.desc
                holder.itemView.imageView.setImageResource(item.imageUrl)

            }else{
                holder.itemView.onboarding_text_1.visibility=View.GONE
                holder.itemView.onboarding_text_2.visibility=View.GONE
                holder.itemView.onboarding_text_3.visibility=View.VISIBLE
                holder.itemView.guideline2.setGuidelinePercent(0.2f)
                holder.itemView.guideline5.setGuidelinePercent(0.65f)

                holder.itemView.onboarding_text_3.text=item.title
                holder.itemView.imageView.setImageResource(item.imageUrl)
            }

    }

    class OnboardingViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView)
}