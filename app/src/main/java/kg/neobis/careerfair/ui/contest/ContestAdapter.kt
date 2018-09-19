package kg.neobis.careerfair.ui.contest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_contest.view.*

class ContestAdapter(var listener: Listener, var mList: Array<String>) : RecyclerView.Adapter<ContestAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false)
        return ViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int){
            itemView.tvContest.text = mList[position]
            itemView.tvContest.setOnClickListener {
                listener.onItemSelectedAt(position)
            }
            itemView.ivHint.setOnClickListener {
                listener.onHintSelectedAt(position)
            }
        }
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
        fun onHintSelectedAt(position: Int)
    }
}