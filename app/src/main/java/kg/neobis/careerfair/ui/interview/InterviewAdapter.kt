package kg.neobis.careerfair.ui.interview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_interview.view.*

class InterviewAdapter(var mList :  Array<out String>, var listener: Listener) : RecyclerView.Adapter<InterviewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_interview, parent, false)
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
            itemView.tvTopic.text = mList[position]
            itemView.btnRedirect.setOnClickListener {
                listener.onItemSelectedAt(position)
            }
        }
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)

    }
}