package kg.neobis.careerfair.ui.employers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_organizers.view.*

class EmployersAdapter(var listener: Listener) : RecyclerView.Adapter<EmployersAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_organizers, parent, false))
    }


    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {

        holder.logoOfCompany.setImageResource(R.drawable.default_image_for_organizers128px)

//        holder.frameForCategory.setOnClickListener {
//            listener.onItemSelectedAt(position)
//        }


    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var logoOfCompany = view.logo_of_company


    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}