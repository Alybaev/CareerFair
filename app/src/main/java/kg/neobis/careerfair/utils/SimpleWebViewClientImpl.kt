package kg.neobis.careerfair.utils

import android.app.Activity
import android.content.Intent
import android.webkit.WebView
import android.webkit.WebViewClient
import kg.neobis.careerfair.R
import kg.neobis.careerfair.data.Preference
import kg.neobis.careerfair.ui.contest.ContestActivity
import kg.neobis.careerfair.ui.main.MainActivity
import kg.neobis.careerfair.utils.Constants.URL_OF_ABOUT_CAREER_RESPONSE_GOOGLE_FORM
import kg.neobis.careerfair.utils.Constants.URL_OF_CV_RESPONSE_GOOGLE_FORM
import kg.neobis.careerfair.utils.Constants.URL_OF_MOCK_RESPONSE_GOOGLE_FORM

class SimpleWebViewClientImpl(var activity: Activity) : WebViewClient() {

    override fun shouldOverrideUrlLoading(webView: WebView, url: String): Boolean {
        if (url == Constants.URL_OF_REGISTRATION_GOOGLE_FORM || url == Constants.URL_OF_MOCK_GOOGLE_FORM || url == Constants.URL_OF_CV_GOOGLE_FORM) {
            return false
        }
        return false
    }

    override fun onPageFinished(view: WebView, url: String) {
        var intent = Intent(activity, MainActivity::class.java)
        if (url.contains(Constants.URL_OF_REGISTRATION_RESPONSE_GOOGLE_FORM)) {
            Preference.setToken(activity, "true")
        } else if (url.contains(URL_OF_CV_RESPONSE_GOOGLE_FORM) || url.contains(URL_OF_MOCK_RESPONSE_GOOGLE_FORM) || url.contains(URL_OF_ABOUT_CAREER_RESPONSE_GOOGLE_FORM)) {
            intent = Intent(activity, ContestActivity::class.java)
            val urlResponses = activity.resources.getStringArray(R.array.urls_responses)
            for (i in 0 until urlResponses.size) {
                if (url.contains(urlResponses[i])) {
                    Preference.setToken(activity, urlResponses[i])
                }
            }
        }
        activity.startActivity(intent)
        activity.finish()
        super.onPageFinished(view, url)
    }
}