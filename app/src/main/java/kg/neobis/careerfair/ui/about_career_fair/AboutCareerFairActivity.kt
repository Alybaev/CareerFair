package kg.neobis.careerfair.ui.about_career_fair

import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.bumptech.glide.Glide
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.organizers.OrganizersContract
import kg.neobis.careerfair.ui.organizers.OrganizersPresenter
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.Constants.Companion.PATH_FOR_ORGANIZERS
import kotlinx.android.synthetic.main.activity_about_career_fair.*

class AboutCareerFairActivity : BaseActivity(), AboutCareerFairContract.View,OrganizersContract.View {
    var info : List<Organizers>? = null
    override fun onSuccess(result: List<Organizers>) {
        info = result
        logo_image.background = ContextCompat.getDrawable(this, R.color.lightGreyColor)
        Glide.with(this)
                .load(info!![0].logo_url)
                .into(logo_image)
         about_career_fair_text_view.text = info!![0].description
    }

    private var infoAboutCareerFair: List<AboutCareerFair>?  = null
    private var presenter: AboutCareerFairPresenter? = null
    private var presenterOrganizers: OrganizersPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_career_fair)
        init()
    }

    private var namesOfCategories: Array<out String>? = null

    private fun init() {
        namesOfCategories = resources.getStringArray(R.array.categories_name)
        initPresenter()
    }


    private fun initPresenter() {
        val intent = intent
        var name = intent.getStringExtra(Constants.NAME_OF_CATEGORY_KEY)
        var name2 = namesOfCategories!![4]
        if(name == namesOfCategories!![4]){
            title = namesOfCategories!![4]
            presenterOrganizers = OrganizersPresenter(this)
            presenterOrganizers!!.getInfo(PATH_FOR_ORGANIZERS)
        }else {
            presenter = AboutCareerFairPresenter(this)
            presenter!!.getInfoAboutCareerFair()
        }
    }
    override fun onSuccessAboutCarerrFair(result: List<AboutCareerFair>) {
        infoAboutCareerFair = result as ArrayList
        if(infoAboutCareerFair!!.isNotEmpty()) {
            about_career_fair_text_view.text = infoAboutCareerFair!![0].description + "\n\n" + infoAboutCareerFair!![0].target +
                    "\n\n" +   infoAboutCareerFair!![0].mission + "\n\n" +infoAboutCareerFair!![0].task
        }

    }
}
