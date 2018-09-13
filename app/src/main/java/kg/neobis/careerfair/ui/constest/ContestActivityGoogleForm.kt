package kg.neobis.careerfair.ui.constest

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.custom_classes.SimpleWebViewClientImpl
import kotlinx.android.synthetic.main.activity_login2.*


class ContestActivityGoogleForm() : BaseActivity() {

    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        init()
    }

    private fun init() {
        getDataFromIntent()
        initWebView()
    }


    private fun getDataFromIntent() {
        url = intent.getStringExtra(Constants.URL_KEY)
    }

    private fun initWebView() {

        val webSettings = webViewRegistration.getSettings()
        webSettings.javaScriptEnabled = true

        val webViewClient = SimpleWebViewClientImpl(this)
        webViewRegistration.webViewClient = webViewClient

        webViewRegistration.loadUrl(url)
    }

    //       initListeners()
    public override fun onBackPressed() {
        if (webViewRegistration.canGoBack()) {
            webViewRegistration.goBack()
        } else {
            super.onBackPressed()
        }
    }


}
