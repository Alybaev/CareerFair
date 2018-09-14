package kg.neobis.careerfair.ui.organizers

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.Constants.Companion.PATH_FOR_ORGANIZERS
import kotlinx.android.synthetic.main.activity_organizers.*


class OrganizersActivity : BaseActivity(), OrganizersAdapter.Listener, OrganizersContract.View {


    var mAdapter: OrganizersAdapter? = null
    private var presenter: OrganizersPresenter? = null
    private var nameOfCategory: String?= null
    private var info: ArrayList<Organizers>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizers)

        init()
    }

    private fun init() {

        getDataFromIntent()
        initAdapter()
        initPresenter()
    }


    private fun initPresenter() {

        presenter = OrganizersPresenter(this)
        val namesOfCategories = resources.getStringArray(R.array.categories_name)
        when(nameOfCategory){
            namesOfCategories[4] ->   presenter!!.getInfo(PATH_FOR_ORGANIZERS)
        }


    }


    private fun getDataFromIntent() {

        val intent = intent
        nameOfCategory = intent.getStringExtra(Constants.NAME_OF_CATEGORY_KEY)
        title = nameOfCategory

    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        info =  ArrayList<Organizers>()
        mAdapter = OrganizersAdapter(this,this,info!!)
        RecycleViewOrganizers.layoutManager = layoutManager
        RecycleViewOrganizers.adapter = mAdapter

    }

    override fun onItemSelectedAt(position: Int) {
        info_text_view_organizers.text = info!![position].description
    }
    override fun onSuccess(result: List<Organizers>) {

        info = result as ArrayList<Organizers>
        info_text_view_organizers.text = info!![0].description
        mAdapter!!.setMData(info!!)

    }
}
