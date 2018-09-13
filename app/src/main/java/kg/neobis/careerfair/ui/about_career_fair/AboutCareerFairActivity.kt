package kg.neobis.careerfair.ui.about_career_fair

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity

class AboutCareerFairActivity : BaseActivity(), AboutCareerFairContract.View {
    override fun onSuccess(result: List<Any>) {

    }

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
}
