package kg.neobis.careerfair.ui.main_menu

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.about_career_fair.AboutCareerFairActivity
import kg.neobis.careerfair.ui.constest.ContestActivity
import kg.neobis.careerfair.ui.employers.EmployersActivity
import kg.neobis.careerfair.ui.interview.InterviewActivity
import kg.neobis.careerfair.ui.map.MapActivity
import kg.neobis.careerfair.ui.organizers.OrganizersActivity
import kg.neobis.careerfair.ui.shedule.ScheduleActivity
import kg.neobis.careerfair.utils.Constants.Companion.NAME_OF_CATEGORY_KEY
import kotlinx.android.synthetic.main.activity_main_menu.*


class MainMenuActivity : AppCompatActivity(), MainMenuAdapter.Listener {


    var namesOfCategories: Array<String>? = null
    var mAdapter: MainMenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        init()


    }

    private fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }

    private fun init() {
        about_career_fair_text.text = fromHtml(getString(R.string.about_career_fair_text))
        initAdapter()
        initListener()
    }

    private fun initListener() {

        about_career_fair.setOnClickListener {
            val intent = Intent(this,AboutCareerFairActivity :: class.java)
            startActivity(intent)
        }

    }

    private fun initAdapter() {

        namesOfCategories = resources.getStringArray(R.array.categories_name)
        mAdapter = MainMenuAdapter(this, namesOfCategories!!)
        recycleViewOfCategories.adapter = mAdapter


    }

    override fun onItemSelectedAt(position: Int, nameOfCategory: String) {
        var intent = Intent(this, OrganizersActivity::class.java)

        when (position) {

            0 -> intent = Intent(this, ScheduleActivity::class.java)
            1 -> intent = Intent(this, MapActivity::class.java)
            2 -> intent = Intent(this, EmployersActivity::class.java)
            4 -> intent = Intent(this, AboutCareerFairActivity :: class.java)
            3 -> intent = Intent(this, ContestActivity::class.java)
            7 -> intent = Intent(this, InterviewActivity::class.java)


        }
        intent.putExtra(NAME_OF_CATEGORY_KEY, nameOfCategory)

        startActivity(intent)
        overridePendingTransition(R.anim.abc_fade_in,R.anim.abc_fade_out);


    }
}
