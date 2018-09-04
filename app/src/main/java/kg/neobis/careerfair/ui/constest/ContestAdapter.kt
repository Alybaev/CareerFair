package kg.neobis.careerfair.ui.constest

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_contest.view.*

class ContestAdapter(var listener: Listener, var namesOfContest: Array<String>) : RecyclerView.Adapter<ContestAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contest, parent, false))
    }

    override fun getItemCount(): Int {
        return namesOfContest.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        holder.titleOfContest.text = namesOfContest[position]
        holder.buttonParticipation.setOnClickListener {
            listener.onItemSelectedAt(position)
        }

    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleOfContest = view.title_of_contest
        var buttonParticipation = view.take_part_in_contest
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}