package kg.neobis.careerfair.ui.main_menu

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_category.view.*


class MainMenuAdapter(var listener: Listener, var namesOfCategories: Array<String>) : RecyclerView.Adapter<MainMenuAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }


    override fun getItemCount(): Int {
        return namesOfCategories.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.categoryTextView.text = namesOfCategories[position]
        if (position % 2 == 0) {
            holder.shadowView2.visibility = View.VISIBLE
            holder.frameForCategory2.visibility = View.VISIBLE
            holder.yellowLineImage2.visibility = View.VISIBLE

            holder.shadowView.visibility = View.INVISIBLE
            holder.frameForCategory.visibility = View.INVISIBLE
            holder.yellowLineImage.visibility = View.INVISIBLE

        } else {
            holder.shadowView2.visibility = View.INVISIBLE
            holder.frameForCategory2.visibility = View.INVISIBLE
            holder.yellowLineImage2.visibility = View.INVISIBLE

            holder.shadowView.visibility = View.VISIBLE
            holder.frameForCategory.visibility = View.VISIBLE
            holder.yellowLineImage.visibility = View.VISIBLE
        }
        holder.frameForCategory.setOnClickListener {
            listener.onItemSelectedAt(position)
        }
        holder.frameForCategory2.setOnClickListener {
            listener.onItemSelectedAt(position)
        }

    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var categoryTextView = view.category_text

        var shadowView = view.shadow_view
        var frameForCategory = view.frame_for_category
        var yellowLineImage = view.yellow_line_image

        var shadowView2 = view.shadow_view2
        var frameForCategory2 = view.frame_for_category2
        var yellowLineImage2 = view.yellow_line_image2

    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}