package kg.neobis.careerfair.ui.about_app

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.about_career_fair.AboutCareerFairContract
import kg.neobis.careerfair.ui.about_career_fair.AboutCareerFairPresenter
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_about_app.*

class AboutAppActivity : BaseActivity(),AboutCareerFairContract.View {
    override fun onSuccessAboutCarerrFair(result: List<AboutCareerFair>) {
        if(result.isNotEmpty()) {
            tvTitleAboutApp.text = result[0].title
            tvAboutApp.text = result[0].description
        }
    }

    var presenter  = AboutCareerFairPresenter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_app)

        presenter.getInfoAboutCareerFair(Constants.PATH_FOR_APP)
    }
}
