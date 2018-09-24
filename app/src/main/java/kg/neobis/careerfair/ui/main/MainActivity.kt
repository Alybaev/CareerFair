package kg.neobis.careerfair.ui.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.about_app.AboutAppActivity
import kg.neobis.careerfair.ui.about_career_fair.AboutCareerFairActivity
import kg.neobis.careerfair.ui.contest.ContestActivity
import kg.neobis.careerfair.ui.employers.EmployersActivity
import kg.neobis.careerfair.ui.interview.InterviewActivity
import kg.neobis.careerfair.ui.map.MapActivity
import kg.neobis.careerfair.ui.organizers.OrganizersActivity
import kg.neobis.careerfair.ui.shedule.ScheduleActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainActivity : AppCompatActivity(), Adapter.Listener {
    var mAdapter: Adapter? = null

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
        tvAbout.text = fromHtml(getString(R.string.about_career_fair_text))
        layoutAbout.setOnClickListener {
            startActivity(Intent(this, AboutCareerFairActivity::class.java))
        }
        initAdapter()
    }

    private fun initAdapter() {
        val mList = resources.getStringArray(R.array.categories_name)
        mAdapter = Adapter(this, mList)
        rvCategory.adapter = mAdapter
    }

    override fun onItemSelectedAt(position: Int, nameOfCategory: String) {
        val intent = Intent(this,
                when (position) {
                    0 -> ScheduleActivity::class.java
                    1 -> MapActivity::class.java
                    2 -> EmployersActivity::class.java
                    3 -> ContestActivity::class.java
                    4 -> AboutCareerFairActivity::class.java
                    7 -> InterviewActivity::class.java
                    8 -> AboutAppActivity::class.java
                    9 -> AboutCareerFairActivity::class.java
                    else -> OrganizersActivity::class.java
                })
        intent.putExtra(Constants.NAME_OF_CATEGORY_KEY, nameOfCategory)
        startActivity(intent)
    }
}
