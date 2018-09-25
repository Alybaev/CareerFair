package kg.neobis.careerfair.ui.about_career_fair

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.method.LinkMovementMethod
import com.bumptech.glide.Glide
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.organizers.OrganizersContract
import kg.neobis.careerfair.ui.organizers.OrganizersPresenter
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_about_career_fair.*


class AboutCareerFairActivity : BaseActivity(), AboutCareerFairContract.View, OrganizersContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_career_fair)
        init()
    }

    private fun init() {
        initPresenter()
    }

    private fun initPresenter() {
        val name = intent.getStringExtra(Constants.NAME_OF_CATEGORY_KEY)
        title = name
        val list = resources.getStringArray(R.array.categories_name)
        if (name == list[4]) {
            title = list[4]
            OrganizersPresenter(this).getInfo(Constants.PATH_FOR_ORGANIZERS)
        } else if(name == list[8]){
            title = list[8]
            ivLogo.setImageResource(R.drawable.about_hackaton_drawable)
            tvAbout.text = getString(R.string.about_hackaton)
            tvAbout.setMovementMethod(LinkMovementMethod.getInstance());
        }
        else{
            AboutCareerFairPresenter(this).getInfoAboutCareerFair(Constants.PATH_FOR_CAREER)
        }
    }

    override fun onSuccessAboutCarerrFair(result: List<AboutCareerFair>) {
        if (result.isNotEmpty()) {
            tvAbout.text = result[0].description

        }
        ivLogo.setImageResource(R.drawable.logo)
        ivLogo.setBackgroundColor(ContextCompat.getColor(this,R.color.logo_background))
    }

    override fun onSuccess(result: ArrayList<Organizers>) {
        if (result.isNotEmpty()) {
            ivLogo.background = ContextCompat.getDrawable(this, R.color.lightGreyColor)
            Glide.with(this)
                    .load(result[0].logo_url)
                    .into(ivLogo)
            tvAbout.text = result[0].description
        }
    }
}
