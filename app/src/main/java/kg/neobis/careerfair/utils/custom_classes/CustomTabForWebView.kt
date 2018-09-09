package kg.neobis.careerfair.utils.custom_classes

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.customtabs.CustomTabsIntent


class CustomTabForWebView(){
    fun openUrlInChromeCustomTab(context: Activity, url: String) {
        try {
            val builder = CustomTabsIntent.Builder()
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