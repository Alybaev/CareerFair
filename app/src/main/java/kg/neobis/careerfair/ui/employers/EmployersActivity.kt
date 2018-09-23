package kg.neobis.careerfair.ui.employers

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.custom.DividerItemDecoration
import kg.neobis.careerfair.ui.organizers.OrganizersContract
import kg.neobis.careerfair.ui.organizers.OrganizersPresenter
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_employers.*

class EmployersActivity : BaseActivity(), EmployersAdapter.Listener, OrganizersContract.View {

    private var presenter: OrganizersContract.Presenter? = null
    private var mAdapter: EmployersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employers)
        init()
    }

    override fun onSuccess(result: ArrayList<Organizers>) {
        mAdapter?.setMData(result)
    }

    fun init() {
        initAdapter()
        initPresenter()
    }

    private fun initPresenter() {
        presenter = OrganizersPresenter(this)
        presenter?.getInfo(Constants.PATH_FOR_EMPLOYERS)
    }

    override fun onItemSelectedAt(item: Organizers) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }

    private fun initAdapter() {
        mAdapter = EmployersAdapter(this, ArrayList<Organizers>())
        rvEmployer.adapter = mAdapter
    }
}