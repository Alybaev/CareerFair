package kg.neobis.careerfair.ui.employers

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.organizers.OrganizersAdapter
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_employers.*
import kotlinx.android.synthetic.main.activity_organizers.*

class EmployersActivity : BaseActivity(),EmployersAdapter.Listener {

    private var mAdapter: EmployersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employers)
        initAdapter()
    }

    override fun onItemSelectedAt(position: Int,nameOfEmployer : String) {
        val intent = Intent(this,DetailInfoAboutEmployerActivity::class.java)
        intent.putExtra(Constants.NAME_OF_EMPLOYER_KEY, nameOfEmployer)
    }


    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter = EmployersAdapter(this)
        recycleViewOfEmployers.layoutManager = layoutManager
        recycleViewOfEmployers.adapter = mAdapter

    }
}
