package kg.neobis.careerfair.ui.shedule

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.model.Shedule
import kg.neobis.careerfair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_shedule.*

class ScheduleActivity : BaseActivity(),ScheduleAdapter.Listener,ScheduleContract.View{
    var infoAboutSchedule : ArrayList<Shedule>? = null
    var presenter : SchedulePresenter? = null
    private var mAdapter: ScheduleAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shedule)
        init()
    }

    private fun init() {

        initAdapter()
        initPresenter()
    }


    private fun initPresenter() {
        presenter = SchedulePresenter(this)
        presenter!!.getSchedule()

    }

    override fun onSuccess(result: List<Any>) {
        infoAboutSchedule = result as ArrayList<Shedule>
        mAdapter!!.setMData(infoAboutSchedule!!)
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        infoAboutSchedule = ArrayList()
        mAdapter = ScheduleAdapter(this,infoAboutSchedule!!)
        RecycleViewSchedule.layoutManager = layoutManager
        RecycleViewSchedule.adapter = mAdapter

    }



    override fun onItemSelectedAt(position: Int) {

    }

}
