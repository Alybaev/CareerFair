package kg.neobis.careerfair.ui.employers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants

class EmployersActivity : BaseActivity(),EmployersAdapter.Listener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employers)
    }

    override fun onItemSelectedAt(position: Int,nameOfEmployer : String) {
        val intent = Intent(this,DetailInfoAboutEmployerActivity::class.java)
        intent.putExtra(Constants.NAME_OF_EMPLOYER_KEY, nameOfEmployer)
    }
}
