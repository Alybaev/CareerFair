package kg.neobis.careerfair.ui.employers

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_detail_info_about_employer.*
import kotlinx.android.synthetic.main.item_employers.view.*

class DetailInfoAboutEmployerActivity : BaseActivity() {

    private var position: Int? = null
    private var info: ArrayList<Organizers>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_detail_info_about_employer)

        getDataFromIntent()
        initIncludedView()
    }

    private fun initIncludedView() {
        item_about_employer.name_of_employer.text = info!![position!!].full_name
        item_about_employer.company_of_employer.text = info!![position!!].full_name
        description_about_employer_detail.text = info!![position!!].description
    }

    private fun getDataFromIntent() {
        info = intent.getSerializableExtra(Constants.INFO_KEY) as ArrayList<Organizers>
        position = intent.getIntExtra(Constants.POSITION_KEY,0)
        title = info!![position!!].full_name


    }
}
