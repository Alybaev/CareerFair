package kg.neobis.careerfair.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kg.neobis.careerfair.R
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.custom_classes.SimpleWebViewClientImpl
import kotlinx.android.synthetic.main.activity_login_web.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_web)
        init()
    }

    private fun init() {
        webViewRegistration.settings.javaScriptEnabled = true

        val webViewClient = SimpleWebViewClientImpl(this)
        webViewRegistration.webViewClient = webViewClient

        webViewRegistration.loadUrl(Constants.URL_OF_REGISTRATION_GOOGLE_FORM)
    }
}