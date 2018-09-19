package kg.neobis.careerfair.ui.organizers

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_organizers.*

class OrganizersActivity : BaseActivity(), OrganizersAdapter.Listener, OrganizersContract.View {
    private var presenter: OrganizersContract.Presenter? = null
    private var mAdapter: OrganizersAdapter? = null
    private var info: ArrayList<Organizers>? = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizers)
        init()
    }

    private fun init() {
        val name = intent.getStringExtra(Constants.NAME_OF_CATEGORY_KEY)
        title = name
        initAdapter()
        presenter = OrganizersPresenter(this)
        val list = resources.getStringArray(R.array.categories_name)

        presenter?.getInfo(when (name) {
            list[4] -> Constants.PATH_FOR_ORGANIZERS
            list[5] -> Constants.PATH_FOR_PARTNERS
            list[6] -> Constants.PATH_FOR_SPONSORS
            else -> null
        })
    }

    private fun initAdapter() {
        val info = ArrayList<Organizers>()
        mAdapter = OrganizersAdapter(this, this, info)
        rvOrganizers.adapter = mAdapter
    }

    override fun onItemSelectedAt(position: Int) {
        tvOrganizers.text = info!![position].description
    }

    override fun onSuccess(result: ArrayList<Organizers>) {
        info = result
        if (info != null && !info!!.isEmpty())
            tvOrganizers.text = info!![0].description
        mAdapter?.setMData(info!!)
    }
}
