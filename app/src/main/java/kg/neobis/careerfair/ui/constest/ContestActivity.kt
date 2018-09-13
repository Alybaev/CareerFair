package kg.neobis.careerfair.ui.constest

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kg.neobis.careerfair.R

import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.FileUtils
import kg.neobis.careerfair.utils.custom_classes.CustomTabForWebView
import kotlinx.android.synthetic.main.activity_contest.*

class ContestActivity : BaseActivity(), ContestAdapter.Listener {

    private var mAdapter: ContestAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contest)
        init()
    }

    private fun init() {
        initAdapter()
    }


    private fun initAdapter() {

        var namesOfContests = resources.getStringArray(R.array.name_contests)
        mAdapter = ContestAdapter(this, namesOfContests!!)


        var layoutManager = LinearLayoutManager(this)
        RecycleViewContest.layoutManager = layoutManager
        RecycleViewContest.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation))
        RecycleViewContest.adapter = mAdapter

    }

    override fun onItemSelectedAt(position: Int) {
        var intent = Intent(this, ContestActivityGoogleForm::class.java)

        val checkMockRegistration: String? = FileUtils.readCacheData<String>(this, Constants.URL_KEY_FOR_CACHE_MOCK)
        val checkCVRegistration: String? = FileUtils.readCacheData<String>(this, Constants.URL_KEY_FOR_CACHE_CV)
        when (position) {

            0 -> if (checkMockRegistration == null) {
                intent.putExtra(Constants.URL_KEY, Constants.URL_OF_MOCK_GOOGLE_FORM)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Вы уже учавствуете в этом конкурсе",Toast.LENGTH_SHORT).show()
            }
            1 ->  if (checkCVRegistration == null) {
                intent.putExtra(Constants.URL_KEY, Constants.URL_OF_CV_GOOGLE_FORM)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Вы уже учавствуете в этом конкурсе",Toast.LENGTH_SHORT).show()
            }





        }
    }
}
