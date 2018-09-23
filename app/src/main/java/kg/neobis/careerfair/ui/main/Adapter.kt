package kg.neobis.careerfair.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_category.view.*

class Adapter(var listener: Listener, var mList: Array<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            if (position % 2 == 0) {
                itemView.frame_for_category2.visibility = View.VISIBLE
                itemView.yellow_line_image2.visibility = View.VISIBLE
                itemView.frame_for_category.visibility = View.INVISIBLE
                itemView.yellow_line_image.visibility = View.INVISIBLE

            } else {
                itemView.frame_for_category2.visibility = View.INVISIBLE
                itemView.yellow_line_image2.visibility = View.INVISIBLE
                itemView.frame_for_category.visibility = View.VISIBLE
                itemView.yellow_line_image.visibility = View.VISIBLE
            }
            itemView.tvCategory.text = mList[position]

            itemView.frame_for_category.setOnClickListener {
                listener.onItemSelectedAt(position, mList[position])
            }
            itemView.frame_for_category2.setOnClickListener {
                listener.onItemSelectedAt(position, mList[position])
            }
        }
    }

    interface Listener {
        fun onItemSelectedAt(position: Int, nameOfCategory: String)
    }
}