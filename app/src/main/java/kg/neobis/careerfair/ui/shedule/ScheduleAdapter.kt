package kg.neobis.careerfair.ui.shedule


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Shedule
import kotlinx.android.synthetic.main.item_shedule.view.*


class ScheduleAdapter(var listener: Listener, var infoAboutSchedule : ArrayList<Shedule>) : RecyclerView.Adapter<ScheduleAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shedule, parent, false))
    }


    override fun getItemCount(): Int {
        return infoAboutSchedule.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {

        holder.time.text = infoAboutSchedule[position].time.substring(0,infoAboutSchedule[position].time.length - 3)
        holder.topic.text = infoAboutSchedule[position].subject
        holder.place.text = infoAboutSchedule[position].place
        holder.speaker.text =  infoAboutSchedule[position].speaker

//        holder.frameForCategory.setOnClickListener {
//            listener.onItemSelectedAt(position)
//        }


    }

    fun setMData(info:  ArrayList<Shedule>) {
        this.infoAboutSchedule = info
        notifyDataSetChanged()
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