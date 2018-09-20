package kg.neobis.careerfair.ui.shedule


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Shedule
import kotlinx.android.synthetic.main.item_shedule.view.*


class ScheduleAdapter(var listener: Listener, var mList: ArrayList<Shedule>) : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_shedule, parent, false)
        return ViewHolder(mView)
    }


    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList.get(position))
    }

    fun setMData(info: ArrayList<Shedule>) {
        this.mList = info
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Shedule) {
            itemView.time_text_start.text = item.start.substring(0, item.start.length - 3)
            itemView.time_text_end.text = item.end.substring(0, item.end.length - 3)
            itemView.topic_text.text = item.subject
            itemView.place_text.text = item.place
        }

    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }
}