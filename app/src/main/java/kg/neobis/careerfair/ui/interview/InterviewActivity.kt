package kg.neobis.careerfair.ui.interview

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_interview.*

class InterviewActivity : BaseActivity(), InterviewAdapter.Listener {
    override fun onItemSelectedAt(position: Int) {


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)
        initAdapter()
    }

    private var topicsOfInterview: Array<out String>? = null

    private var mAdapter: InterviewAdapter? = null

    private fun initAdapter() {

        topicsOfInterview = resources.getStringArray(R.array.interview_topics)
        mAdapter = InterviewAdapter(topicsOfInterview!!, this)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycleViewOfInterview.layoutManager = layoutManager
        recycleViewOfInterview.adapter = mAdapter


    }
}