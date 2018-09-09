package kg.neobis.careerfair.ui.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import android.view.KeyEvent
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.activity_login2.*

import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.custom_classes.SimpleWebViewClientImpl


class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        init()
    }

    private fun init() {
        initWebView()
    }

    private fun initWebView() {

        val webSettings = webViewRegistration.getSettings()
        webSettings.javaScriptEnabled = true

        val webViewClient = SimpleWebViewClientImpl(this)
        webViewRegistration.webViewClient = webViewClient

        webViewRegistration.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSevckocpQKbsAVyn5xKaMBsDbR3rY90n5ItBoPy7xOAxfZkzw/viewform")
    }

    //       initListeners()
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webViewRegistration.canGoBack()) {
            this.webViewRegistration.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }

}


