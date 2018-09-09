package kg.neobis.careerfair.ui

import android.content.Intent
import android.os.Bundle
import kg.neobis.careerfair.ui.main_menu.MainMenuActivity
import android.view.WindowManager
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.login.LoginActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.FileUtils


class MainActivity : AppCompatActivity() {

    private val SLEEP_TIMER = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)
        val logoLauncher = LogoLauncher()
        logoLauncher.start()

    }

    private inner class LogoLauncher : Thread() {
        override fun run() {
            try {
                Thread.sleep((1000 * SLEEP_TIMER).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            var intent = Intent(this@MainActivity, LoginActivity::class.java)
            if(FileUtils.readCacheData<String>(this@MainActivity,Constants.REGISTRATION_KEY ) != null) {
                intent = Intent(this@MainActivity, MainMenuActivity::class.java)
            }


             startActivity(intent)
            this@MainActivity.finish()
        }
    }
}