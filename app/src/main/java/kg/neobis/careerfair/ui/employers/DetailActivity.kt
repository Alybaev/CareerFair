package kg.neobis.careerfair.ui.employers

import android.os.Bundle
import com.bumptech.glide.Glide
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_detail_info_about_employer.*

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_info_about_employer)
        initIncludedView()
    }

    private fun initIncludedView() {
        val item = intent.getSerializableExtra("data") as? Organizers
        title = item?.full_name
        tvName.text = item?.full_name

        Glide.with(this)
                .load(item?.logo_url)
                .into(ivImage)

        tvDescription.text = item?.description
    }
}
