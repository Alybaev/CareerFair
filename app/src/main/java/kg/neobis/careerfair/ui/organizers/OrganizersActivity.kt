package kg.neobis.careerfair.ui.organizers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kg.neobis.careerfair.R
import kotlinx.android.synthetic.main.activity_organizers.*
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.ui.BaseActivity


class OrganizersActivity : BaseActivity(), OrganizersAdapter.Listener {
    override fun onItemSelectedAt(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var mAdapter: OrganizersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_organizers)

        init()
    }

    private fun init() {

        initAdapter()
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter = OrganizersAdapter(this)
        RecycleViewOrganizers.layoutManager = layoutManager
        RecycleViewOrganizers.adapter = mAdapter

    }
}
