package kg.neobis.careerfair.ui.shedule


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_shedule.view.*


class SheduleAdapter(var listener: Listener) : RecyclerView.Adapter<SheduleAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shedule, parent, false))
    }


    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {

        holder.time.text = "12:00"
        holder.topic.text = "Что написать на 'чистой доске' ?"
        holder.place.text = "4 этаж 410 каб."
        holder.speaker.text = "Эндрю Вахтель Джекшенбекович"

//        holder.frameForCategory.setOnClickListener {
//            listener.onItemSelectedAt(position)
//        }


    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var time = view.time_text
        var speaker = view.speaker_name_text
        var topic = view.topic_text
        var place = view.place_text



    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}