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
import android.R.attr.button
import android.R.attr.gravity
import android.view.ViewGroup.LayoutParams.FILL_PARENT
import android.widget.LinearLayout
import android.R.attr.gravity






class MainMenuAdapter(var context: Context, var namesOfCategories: Array<String>) : RecyclerView.Adapter<MainMenuAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, null, false))
    }

    override fun getItemCount(): Int {
        return namesOfCategories.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.categoryTextView.text = namesOfCategories[position]
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
        if (position % 2 != 0) {

            holder.yellowLineImage2.visibility = View.INVISIBLE
            params.gravity =  Gravity.END

        }else{

            holder.yellowLineImage1.visibility = View.INVISIBLE
            params.gravity=  Gravity.START


        }
        holder.shadowView.layoutParams = params



    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var shadowView = view.shadow_view
        var itemCategory = view.item_category
        var categoryTextView = view.category_text
        var frameForCategory = view.frame_for_category
        var yellowLineImage1 = view.yellow_line_image1
        var yellowLineImage2 = view.yellow_line_image2

    }


}