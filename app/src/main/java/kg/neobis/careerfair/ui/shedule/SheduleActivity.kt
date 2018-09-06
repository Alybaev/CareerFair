package kg.neobis.careerfair.ui.shedule

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.organizers.OrganizersAdapter
import kotlinx.android.synthetic.main.activity_organizers.*
import kotlinx.android.synthetic.main.activity_shedule.*

class SheduleActivity : BaseActivity(),SheduleAdapter.Listener {
    override fun onItemSelectedAt(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shedule)
        init()
    }

    private fun init() {

        initAdapter()
    }

    private var mAdapter: SheduleAdapter? = null

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = SheduleAdapter(this)
        RecycleViewSchedule.layoutManager = layoutManager
        RecycleViewSchedule.adapter = mAdapter

    }

}
