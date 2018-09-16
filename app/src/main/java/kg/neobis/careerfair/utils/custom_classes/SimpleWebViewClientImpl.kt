package kg.neobis.careerfair.utils.custom_classes

import android.webkit.WebViewClient
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.webkit.WebView
import android.app.Activity
import android.graphics.Bitmap
import android.net.Uri
import kg.neobis.careerfair.ui.main_menu.MainMenuActivity
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import kg.neobis.careerfair.ui.constest.ContestActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.Constants.Companion.URL_OF_ABOUT_CAREER_RESPONSE_GOOGLE_FORM
import kg.neobis.careerfair.utils.Constants.Companion.URL_OF_CV_RESPONSE_GOOGLE_FORM
import kg.neobis.careerfair.utils.Constants.Companion.URL_OF_MOCK_RESPONSE_GOOGLE_FORM
import kg.neobis.careerfair.utils.FileUtils


class SimpleWebViewClientImpl(var activity: Activity) : WebViewClient() {


    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {

      if (url == Constants.URL_OF_REGISTRATION_GOOGLE_FORM || url == Constants.URL_OF_MOCK_GOOGLE_FORM || url == Constants.URL_OF_CV_GOOGLE_FORM ) {
            return false
      }

        return false


    }

    override fun onPageFinished(view: WebView, url: String) {
        Log.d("WebView", "your current url when webpage loading.. finish$url")
        var intent = Intent(activity, MainMenuActivity::class.java)
        if (url.contains(Constants.URL_OF_REGISTRATION_RESPONSE_GOOGLE_FORM )) {

            FileUtils.writeCacheData(activity, Constants.REGISTRATION_KEY, "true")
            activity!!.startActivity(intent)
            activity.finish()

        }else if(url.contains(URL_OF_CV_RESPONSE_GOOGLE_FORM ) || url.contains(URL_OF_MOCK_RESPONSE_GOOGLE_FORM ) || url.contains(URL_OF_ABOUT_CAREER_RESPONSE_GOOGLE_FORM )){
            intent = Intent(activity, ContestActivity::class.java)
            if (url.contains(URL_OF_CV_RESPONSE_GOOGLE_FORM)) {

                FileUtils.writeCacheData(activity, Constants.URL_KEY_FOR_CACHE_CV, url)
            } else if (url.contains(URL_OF_MOCK_RESPONSE_GOOGLE_FORM)) {
                FileUtils.writeCacheData(activity, Constants.URL_KEY_FOR_CACHE_MOCK, url)
            } else if(url.contains(URL_OF_ABOUT_CAREER_RESPONSE_GOOGLE_FORM)){
                FileUtils.writeCacheData(activity, Constants.URL_KEY_FOR_CACHE_ABOUT_CAREER_FAIR, url)
            }
            activity!!.startActivity(intent)
            activity.finish()
        }

        Thread.sleep(1000)
        super.onPageFinished(view, url)


    }
}