package kg.neobis.careerfair.ui.employers

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_employers.*

class EmployersActivity : BaseActivity(),EmployersAdapter.Listener {

    private var mAdapter: EmployersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employers)
        initAdapter()
    }

    override fun onItemSelectedAt(position: Int, nameOfEmployer: String, company: String) {
        val intent = Intent(this,DetailInfoAboutEmployerActivity::class.java)
        intent.putExtra(Constants.COMPANY_OF_EMPLOYER_KEY, company)
        intent.putExtra(Constants.NAME_OF_EMPLOYER_KEY, nameOfEmployer)
        startActivity(intent)
    }


    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = EmployersAdapter(this)
        recycleViewOfEmployers.layoutManager = layoutManager
        recycleViewOfEmployers.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        recycleViewOfEmployers.adapter = mAdapter

    }
}
