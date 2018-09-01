package kg.neobis.careerfair.ui.MainMenuActivity

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_category.view.*


class MainMenuAdapter(var context: Context, var namesOfCategories: Array<String>) : RecyclerView.Adapter<MainMenuAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, null, false))
    }

    override fun getItemCount(): Int {
        return namesOfCategories.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.categoryTextView.text = namesOfCategories[position]
        if (position % 2 != 0) {
            val paramsShadow = holder.shadowView.layoutParams as RelativeLayout.LayoutParams
            paramsShadow.addRule(RelativeLayout.ALIGN_PARENT_START,RelativeLayout.TRUE)
            holder.shadowView.layoutParams = paramsShadow

            val paramsFrame = holder.frameForCategory.layoutParams as RelativeLayout.LayoutParams
            Log.d("____width" ,holder.frameForCategory.layoutParams.width.toString())
            Log.d("____height" ,holder.frameForCategory.layoutParams.height.toString())
            paramsFrame.addRule(RelativeLayout.ALIGN_PARENT_START,RelativeLayout.TRUE)
            holder.frameForCategory.layoutParams = paramsFrame



            val params2 = holder.yellowLineImage.layoutParams as RelativeLayout.LayoutParams

            params2.addRule(RelativeLayout.ALIGN_PARENT_END,RelativeLayout.TRUE)


            holder.yellowLineImage.layoutParams = params2
        }


    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var shadowView = view.shadow_view
        var categoryTextView = view.category_text
        var frameForCategory = view.frame_for_category
        var yellowLineImage = view.yellow_line_image

    }


}