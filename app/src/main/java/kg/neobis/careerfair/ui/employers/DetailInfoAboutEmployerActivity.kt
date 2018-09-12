package kg.neobis.careerfair.ui.employers

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_detail_info_about_employer.*
import kotlinx.android.synthetic.main.item_employers.*
import kotlinx.android.synthetic.main.item_employers.view.*

class DetailInfoAboutEmployerActivity : BaseActivity() {

    private var name: String? = null
    private var company: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_detail_info_about_employer)

        getDataFromIntent()
        initIncludedView()
    }

    private fun initIncludedView() {
        item_about_employer.name_of_employer.text = name
        item_about_employer.company_of_employer.text = company
    }

    private fun getDataFromIntent() {

        name = intent.getStringExtra(Constants.NAME_OF_EMPLOYER_KEY)
        company = intent.getStringExtra(Constants.COMPANY_OF_EMPLOYER_KEY)
        title = name


    }
}
