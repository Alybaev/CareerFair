package kg.neobis.careerfair.ui.employers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.item_employers.view.*

class EmployersAdapter(var listener: Listener) : RecyclerView.Adapter<EmployersAdapter.MViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {


        return MViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_employers, parent, false))
    }


    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {

        holder.imageOfEmployer.setImageResource(R.drawable.default_image_for_employers128px)
        holder.nameOfEmployer.text  = "Dastan Alybaev"
        holder.companyOfEmployer.text = "Google.com"

        holder.employerInfo.setOnClickListener {
            var name = holder.nameOfEmployer.text
            var company = holder.companyOfEmployer.text
            listener.onItemSelectedAt(position,name.toString(),company.toString())

        }


    }

    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageOfEmployer = view.photo_of_employer
        var nameOfEmployer = view.name_of_employer
        var companyOfEmployer = view.company_of_employer
        var employerInfo = view.employer_info

    }

    interface Listener {
        fun onItemSelectedAt(position: Int, nameOfEmployer: String, company: String)
    }


}