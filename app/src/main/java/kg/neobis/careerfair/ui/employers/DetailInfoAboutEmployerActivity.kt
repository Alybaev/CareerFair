package kg.neobis.careerfair.ui.employers

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants

class DetailInfoAboutEmployerActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getDataFromIntent()
        setContentView(R.layout.activity_detail_info_about_employer)
    }

    private fun getDataFromIntent() {
        intent = intent
        val name = intent.getStringExtra(Constants.NAME_OF_EMPLOYER_KEY)
        title = name

    }
}
