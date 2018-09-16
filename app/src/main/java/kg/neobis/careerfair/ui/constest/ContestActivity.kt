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
import kotlinx.android.synthetic.main.activity_contest.*

class ContestActivity : BaseActivity(), ContestAdapter.Listener {
    override fun onHintSelectedAt(position: Int) {
        showHint(position)
    }

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

        val checkRegistration: String? = FileUtils.readCacheData<String>(this, position.toString())
        val urlsOfForms = resources.getStringArray(R.array.urls)
        if(checkRegistration == null ){
            intent.putExtra(Constants.URL_KEY, urlsOfForms[position])
            startActivity(intent)
        }else {
            Toast.makeText(this,"Вы уже учавствуете в этом конкурсе",Toast.LENGTH_SHORT).show()
        }

    }
    fun showHint(position: Int) {

        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag(Constants.TAG_FOR_SHOW_DIALOG_FRAGMENT)

        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)


        val newFragment = DialogFragmentHint.newInstance(position)
        newFragment!!.show(ft, Constants.TAG_FOR_SHOW_DIALOG_FRAGMENT)


    }
}
