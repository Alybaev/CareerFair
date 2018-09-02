package kg.neobis.careerfair

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.mainMenuActivity.MainMenuActivity


class MainActivity : BaseActivity() {
    private val SPLASH_DISPLAY_LENGTH = (2000).toLong()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(Runnable {
            /* Create an Intent that will start the Menu-Activity. */
            val mainIntent = Intent(this, MainMenuActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}
