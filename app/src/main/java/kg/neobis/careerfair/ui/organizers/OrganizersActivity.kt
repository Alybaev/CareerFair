package kg.neobis.careerfair.ui.organizers

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_organizers.*


class OrganizersActivity : BaseActivity(), OrganizersAdapter.Listener, OrganizersContract.View {
    override fun onSuccess(result: List<Any>) {

    }

    var mAdapter: OrganizersAdapter? = null
    private var presenter: OrganizersPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizers)

        init()
    }

    private fun init() {

        getDataFromIntent()
        initPresenter()
        initAdapter()
    }


    private fun initPresenter() {

        presenter = OrganizersPresenter(this)
        presenter!!.getOrganizers()
    }

    private fun getDataFromIntent() {

        val intent = intent
        val nameOfCategory = intent.getStringExtra(Constants.NAME_OF_CATEGORY_KEY)
        title = nameOfCategory

    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter = OrganizersAdapter(this)
        RecycleViewOrganizers.layoutManager = layoutManager
        RecycleViewOrganizers.adapter = mAdapter

    }

    override fun onItemSelectedAt(position: Int) {

    }
}
