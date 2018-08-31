package kg.neobis.careerfair.ui.MainMenuActivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.text.Html
import kg.neobis.careerfair.R
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.SpannableString
import kotlinx.android.synthetic.main.activity_main_menu.*
import android.os.Build
import android.text.Spanned




class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)

        about_career_fair.text = fromHtml(getString(R.string.about_career_fair_text))
    }

    fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            Html.fromHtml(html)
        }
    }
}
