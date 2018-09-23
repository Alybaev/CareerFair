package kg.neobis.careerfair.ui.employers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kotlinx.android.synthetic.main.item_employers.view.*


class EmployersAdapter(var listener: Listener, var mList: ArrayList<Organizers>) : RecyclerView.Adapter<EmployersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_employers, parent, false)
        return ViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            Glide.with(itemView)
                    .load(mList[position].logo_url)
                    .apply(RequestOptions()
                            .centerInside()
                            .override(250, 250)
                            .error(R.drawable.default_image_for_employers128px))
                    .into(itemView.photo_of_employer)

            itemView.name_of_employer.text = mList[position].full_name
            itemView.company_of_employer.text = mList[position].description

            itemView.employer_info.tag = mList.get(position)
            itemView.employer_info.setOnClickListener {it ->
                listener.onItemSelectedAt(it.tag as Organizers)
            }
        }
    }

    fun setMData(info: ArrayList<Organizers>) {
        this.mList = info
        notifyDataSetChanged()
    }

    interface Listener {
        fun onItemSelectedAt(item: Organizers)
    }

}