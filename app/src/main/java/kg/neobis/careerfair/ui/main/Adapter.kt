package kg.neobis.careerfair.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amulyakhare.textdrawable.TextDrawable
import com.amulyakhare.textdrawable.util.ColorGenerator
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_category.view.*

class Adapter(var listener: Listener, var mList: Array<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var generator = ColorGenerator.MATERIAL

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
            // Get the first letter of list item
            val letter = mList[position][0].toString()
            // Create a new TextDrawable for our image's background
            val drawable = TextDrawable.builder().buildRound(letter, generator.randomColor)
            itemView.imageView.setImageDrawable(drawable)

            itemView.tvCategory.text = mList[position]

            itemView.setOnClickListener {
                listener.onItemSelectedAt(position, mList[position])
            }
        }
    }

    interface Listener {
        fun onItemSelectedAt(position: Int, nameOfCategory: String)
    }
}