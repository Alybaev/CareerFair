package kg.neobis.careerfair.ui.organizers

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kotlinx.android.synthetic.main.item_organizers.view.*


class OrganizersAdapter(var listener: Listener, var mList: ArrayList<Organizers>) : RecyclerView.Adapter<OrganizersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.item_organizers, parent, false)
        return ViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int){
            if (mList.get(position).logo_url != null) {
                Glide.with(itemView.context)
                        .asBitmap()
                        .load(mList.get(position).logo_url)
                        .into(itemView.logo_of_company)
            } else {
                Glide.with(itemView.context)
                        .load(R.drawable.default_image_for_organizers128px)
                        .apply(RequestOptions.circleCropTransform())
                        .into(itemView.logo_of_company)
            }
            itemView.logo_of_company.setOnClickListener {
                listener.onItemSelectedAt(position)
            }
        }
    }

    fun setMData(info: ArrayList<Organizers>) {
        this.mList = info
        notifyDataSetChanged()
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }
}