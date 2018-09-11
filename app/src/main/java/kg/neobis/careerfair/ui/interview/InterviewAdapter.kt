package kg.neobis.careerfair.ui.interview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_interview.view.*
import kotlinx.android.synthetic.main.item_organizers.view.*
import kotlinx.android.synthetic.main.item_shedule.view.*


class InterviewAdapter(var interviewTopics :  Array<out String>, var listener: Listener) : RecyclerView.Adapter<InterviewAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_interview, parent, false))
    }


    override fun getItemCount(): Int {
        return interviewTopics.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {

        holder.topic.text = interviewTopics[position]

        holder.buttonGoToInteview.setOnClickListener {
            listener.onItemSelectedAt(position)
        }


    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var topic = view.topic_text_view
        var buttonGoToInteview = view.go_to_interview_button


    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}