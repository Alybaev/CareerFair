package kg.neobis.careerfair.ui.employers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kotlinx.android.synthetic.main.item_employers.view.*
import android.graphics.BitmapFactory
import android.net.Uri
import java.io.File


class EmployersAdapter(var context: Context, var listener: Listener, var info: ArrayList<Organizers>) : RecyclerView.Adapter<EmployersAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_employers, parent, false))
    }


    override fun getItemCount(): Int {
        return info.size
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {




        Glide.with(context)
                .asBitmap()
                .load(info[position].logo_url)
                .into(holder.imageOfEmployer)

        holder.nameOfEmployer.text = info[position].full_name
        holder.companyOfEmployer.text = info[position].description

        holder.employerInfo.setOnClickListener {
            listener.onItemSelectedAt(position)
        }


    }



    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageOfEmployer = view.photo_of_employer
        var nameOfEmployer = view.name_of_employer
        var companyOfEmployer = view.company_of_employer
        var employerInfo = view.employer_info

    }

    fun setMData(info: ArrayList<Organizers>?) {
        if(info == null)
            return
        this.info = info
        notifyDataSetChanged()
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}