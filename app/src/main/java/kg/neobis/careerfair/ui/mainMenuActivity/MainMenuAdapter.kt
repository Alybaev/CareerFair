package kg.neobis.careerfair.ui.mainMenuActivity

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_category.view.*
import android.widget.LinearLayout


class MainMenuAdapter(var listener: Listener, var namesOfCategories: Array<String>) : RecyclerView.Adapter<MainMenuAdapter.MViewHolder>() {

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
        holder.frameForCategory.setOnClickListener{

            listener.onItemSelectedAt(position)

        }

    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var shadowView = view.shadow_view
        var itemCategory = view.item_category
        var categoryTextView = view.category_text
        var frameForCategory = view.frame_for_category
        var yellowLineImage1 = view.yellow_line_image1
        var yellowLineImage2 = view.yellow_line_image2

    }
    interface Listener{
        fun onItemSelectedAt(position:Int)
    }


}