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
        val info = intent.getSerializableExtra(Constants.INFO_KEY) as? ArrayList<Organizers>
        val position = intent.getIntExtra(Constants.POSITION_KEY,0)
        title = info?.get(position)?.full_name
        tvName.text = position.let { info?.get(it)?.full_name }

        Glide.with(this)
                .load(info?.get(position)?.logo_url)
                .into(ivImage)

        tvDescription.text = info?.get(position)?.description
    }
}
