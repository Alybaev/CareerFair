package kg.neobis.careerfair.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.Window
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import kg.neobis.careerfair.R
import kg.neobis.careerfair.data.Preference
import kg.neobis.careerfair.ui.login.LoginActivity
import kg.neobis.careerfair.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_main.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        val anim_in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        anim_in.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationRepeat(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                val token = Preference.getToken(applicationContext)
                startActivity(Intent(this@SplashScreen, getNextTask(token)))
                finish()
            }
        })
        ivLogo.startAnimation(anim_in)
    }

    private fun getNextTask(token: String): Class<*>? {
        if (TextUtils.isEmpty(token))
            return LoginActivity::class.java
        return MainActivity::class.java
    }
}