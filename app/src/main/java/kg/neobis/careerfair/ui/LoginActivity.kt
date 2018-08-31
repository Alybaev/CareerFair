package kg.neobis.careerfair.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.MainMenuActivity.MainMenuActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        initListeners()
    }

    private fun initListeners() {
        login_button.setOnClickListener{

            startActivity( Intent(this,MainMenuActivity :: class.java))


        }
    }
}