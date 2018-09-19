package kg.neobis.careerfair.data

import android.content.Context
import android.content.SharedPreferences

object Preference {
    private val TOKEN = "token"
    private val SETTINGS_STORAGE_NAME = "neobis.career.fair"

    private fun getString(context: Context?, key: String, defValue: String): String? {
        return getPrefs(context)?.getString(key, defValue)
    }

    private fun getPrefs(context: Context?): SharedPreferences? {
        return context?.getSharedPreferences(SETTINGS_STORAGE_NAME, Context.MODE_PRIVATE)
    }

    private fun getEditor(context: Context?): SharedPreferences.Editor? {
        return context?.getSharedPreferences(SETTINGS_STORAGE_NAME, Context.MODE_PRIVATE)?.edit()
    }

    fun getToken(context: Context?): String {
        return getPrefs(context)?.getString(TOKEN, "") ?: ""
    }

    fun setToken(context: Context?, value: String) {
        getEditor(context)?.putString(TOKEN, value)?.commit()
    }

    fun clearData(context: Context?) {
        getEditor(context)?.clear()?.commit()
    }
}