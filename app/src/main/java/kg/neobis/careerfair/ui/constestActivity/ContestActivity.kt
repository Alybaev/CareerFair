package kg.neobis.careerfair.ui.constestActivity

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_contest.*
import kotlinx.android.synthetic.main.activity_main_menu.*
import kotlinx.android.synthetic.main.activity_shedule.view.*

class ContestActivity : BaseActivity(),ContestAdapter.Listener {

    private var mAdapter: ContestAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)
        init()
    }

    private fun init(){
      initAdapter()
    }


    private fun initAdapter() {

        var namesOfContests = resources.getStringArray(R.array.name_contests)
        mAdapter = ContestAdapter(this, namesOfContests!!)


        var layoutManager = LinearLayoutManager(this)
        RecycleViewContest.layoutManager = layoutManager
        RecycleViewContest.addItemDecoration(DividerItemDecoration(this,layoutManager.orientation))
        RecycleViewContest.adapter = mAdapter

    }
    override fun onItemSelectedAt(position: Int) {

    }
}
