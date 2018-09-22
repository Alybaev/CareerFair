package kg.neobis.careerfair.ui.custom

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.support.customtabs.CustomTabsIntent
import android.support.v4.content.ContextCompat
import kg.neobis.careerfair.R


class CustomTabForWebView(){
    fun openUrlInChromeCustomTab(context: Activity, url: String) {
        try {
            val builder = CustomTabsIntent.Builder()
            builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary))
            val customTabsIntent = builder.build()
            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            customTabsIntent.launchUrl(context, Uri.parse(url))
        } catch (e: ActivityNotFoundException) {
            // might not available.
            //openUrlLinkInWebView(context, url);
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}