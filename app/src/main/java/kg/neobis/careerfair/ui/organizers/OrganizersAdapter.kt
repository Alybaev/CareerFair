package kg.neobis.careerfair.ui.organizers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kotlinx.android.synthetic.main.item_organizers.view.*


class OrganizersAdapter(var context : Context,var listener: Listener,var info : ArrayList<Organizers>) : RecyclerView.Adapter<OrganizersAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_organizers, parent, false))
    }


    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {

        Glide.with(context)
                .load(info[position].logo_url)
                .into(holder.logoOfCompany)
        holder.logoOfCompany.setOnClickListener{
            listener.onItemSelectedAt(position)
        }





    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var logoOfCompany = view.logo_of_company



    }
    fun setMData(info:  ArrayList<Organizers>) {
        this.info = info
        notifyDataSetChanged()
    }
    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}