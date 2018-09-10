package kg.neobis.careerfair.utils.custom_classes

import android.webkit.WebViewClient
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.webkit.WebView
import android.app.Activity
import android.net.Uri
import kg.neobis.careerfair.ui.main_menu.MainMenuActivity
import android.support.v4.content.ContextCompat.startActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.FileUtils


class SimpleWebViewClientImpl(var activity: Activity) : WebViewClient() {


    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {

        if (url.contains("https://docs.google.com/forms/d/e/1FAIpQLSevckocpQKbsAVyn5xKaMBsDbR3rY90n5ItBoPy7xOAxfZkzw/alreadyresponded")) {
            val intent = Intent(activity, MainMenuActivity::class.java)
            FileUtils.writeCacheData(activity, Constants.REGISTRATION_KEY, "true")
            activity!!.startActivity(intent)
            activity.finish()
            return false
        } else if (url == "https://docs.google.com/forms/d/e/1FAIpQLSevckocpQKbsAVyn5xKaMBsDbR3rY90n5ItBoPy7xOAxfZkzw/viewform") {
            return false
        }

        return false


    }
}