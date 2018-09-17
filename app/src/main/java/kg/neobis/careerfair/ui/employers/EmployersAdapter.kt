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

        val w = getWidth(info[position].logo_url.toUri()) + 150
        val h = getHeight(info[position].logo_url.toUri()) + 150

        val maxP = Math.max(w, h)

        Glide.with(context)
                .load(info[position].logo_url)
                .apply(RequestOptions().override(maxP, maxP).fitCenter())
                .into(holder.imageOfEmployer)

        holder.nameOfEmployer.text = info[position].full_name
        holder.companyOfEmployer.text = info[position].description

        holder.employerInfo.setOnClickListener {
            var name = holder.nameOfEmployer.text
            var company = holder.companyOfEmployer.text
            listener.onItemSelectedAt(position)
        }


    }

    fun String.toUri(): Uri {
        return Uri.parse(this)
    }

    private fun getHeight(uri: Uri): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(File(uri.getPath()).getAbsolutePath(), options)
        return options.outHeight


    }

    private fun getWidth(uri: Uri): Int {
        val options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeFile(File(uri.getPath()).getAbsolutePath(), options)

        return options.outWidth

    }


    inner class MViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var imageOfEmployer = view.photo_of_employer
        var nameOfEmployer = view.name_of_employer
        var companyOfEmployer = view.company_of_employer
        var employerInfo = view.employer_info

    }

    fun setMData(info: ArrayList<Organizers>) {
        this.info = info
        notifyDataSetChanged()
    }

    interface Listener {
        fun onItemSelectedAt(position: Int)
    }


}