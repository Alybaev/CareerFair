package kg.neobis.careerfair.ui.constest

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kg.neobis.careerfair.R

import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.CustomTabForWebView
import kotlinx.android.synthetic.main.activity_contest.*

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
        var customTabWebView =  CustomTabForWebView()

        when(position){
            0 -> customTabWebView.openUrlInChromeCustomTab(this,"https://docs.google.com/forms/d/e/1FAIpQLSefttaSmJoYDb5eyyGClHGeXeRWKs2NIu7NKyTjXg0nNDVhUQ/viewform")
            1 -> customTabWebView.openUrlInChromeCustomTab(this,"https://docs.google.com/forms/d/e/1FAIpQLSd8R72J-i6fA2frwliEtyPRNf1KcbLJ69Z3-msrW3bOW5-JUA/viewform")
        }
    }
}
