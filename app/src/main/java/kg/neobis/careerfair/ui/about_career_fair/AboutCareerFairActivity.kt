package kg.neobis.careerfair.ui.about_career_fair

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_about_career_fair.*

class AboutCareerFairActivity : BaseActivity(), AboutCareerFairContract.View {
    private var infoAboutCareerFair: List<AboutCareerFair>?  = null
    private var presenter: AboutCareerFairPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_career_fair)
        init()
    }

    private fun init() {

        initPresenter()
    }


    private fun initPresenter() {
        presenter = AboutCareerFairPresenter(this)
        presenter!!.getInfoAboutCareerFair()
    }
    override fun onSuccess(result: List<AboutCareerFair>) {
        infoAboutCareerFair = result as ArrayList
        if(infoAboutCareerFair!!.isNotEmpty()) {
            about_career_fair_text_view.text = infoAboutCareerFair!![0].description + "\n\n" + infoAboutCareerFair!![0].target +
                    "\n\n" +   infoAboutCareerFair!![0].mission + "\n\n" +infoAboutCareerFair!![0].task
        }

    }
}
