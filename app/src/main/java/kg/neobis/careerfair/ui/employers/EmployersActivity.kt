package kg.neobis.careerfair.ui.employers

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.organizers.OrganizersContract
import kg.neobis.careerfair.ui.organizers.OrganizersPresenter
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.Constants.Companion.PATH_FOR_EMPLOYERS
import kotlinx.android.synthetic.main.activity_employers.*

class EmployersActivity : BaseActivity(),EmployersAdapter.Listener,OrganizersContract.View {
    override fun onSuccess(result: List<Organizers>) {
        info = result as ArrayList
        mAdapter!!.setMData(result)
    }

    private var mAdapter: EmployersAdapter? = null
    private var presenter: OrganizersPresenter? = null
    private var info: ArrayList<Organizers>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employers)
        init()

    }
    fun init(){
        initAdapter()
        initPresenter()
    }

    private fun initPresenter() {
        presenter = OrganizersPresenter(this)
        presenter!!.getInfo(PATH_FOR_EMPLOYERS)
    }

    override fun onItemSelectedAt(position: Int) {
        val intent = Intent(this,DetailInfoAboutEmployerActivity::class.java)
        intent.putExtra(Constants.POSITION_KEY, position)
        intent.putExtra(Constants.INFO_KEY,info )
        startActivity(intent)
    }


    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        info = ArrayList<Organizers>()
        mAdapter = EmployersAdapter(this,this,info!!)
        recycleViewOfEmployers.layoutManager = layoutManager
        recycleViewOfEmployers.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        recycleViewOfEmployers.adapter = mAdapter

    }
}
