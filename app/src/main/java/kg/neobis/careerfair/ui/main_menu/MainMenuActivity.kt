package kg.neobis.careerfair.ui.main_menu

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Html
import android.text.Spanned
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.constest.ContestActivity
import kg.neobis.careerfair.ui.shedule.SheduleActivity
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
        about_career_fair.text = fromHtml(getString(R.string.about_career_fair_text))
        initAdapter()
    }

        private fun initAdapter() {

            namesOfCategories = resources.getStringArray(R.array.categories_name)
            mAdapter = MainMenuAdapter(this, namesOfCategories!!)
            recycleViewOfCategories.adapter = mAdapter


        }

    override fun onItemSelectedAt(position: Int) {
        var intent = Intent(this, SheduleActivity::class.java)
        when (position) {
            3 -> intent = Intent(this, ContestActivity::class.java)
        }
        startActivity(intent)
    }
}