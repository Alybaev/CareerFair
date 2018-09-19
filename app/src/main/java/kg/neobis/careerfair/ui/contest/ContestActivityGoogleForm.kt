package kg.neobis.careerfair.ui.contest

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.custom_classes.SimpleWebViewClientImpl
import kotlinx.android.synthetic.main.activity_login_web.*

class ContestActivityGoogleForm() : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_web)
        initWebView()
    }

    private fun initWebView() {
        webViewRegistration.settings.javaScriptEnabled = true
        val webViewClient = SimpleWebViewClientImpl(this)
        webViewRegistration.webViewClient = webViewClient

        val url = intent.getStringExtra(Constants.URL_KEY)
        webViewRegistration.loadUrl(url)
    }

    override fun onBackPressed() {
        if (webViewRegistration.canGoBack()) {
            webViewRegistration.goBack()
        } else {
            super.onBackPressed()
        }
    }
}