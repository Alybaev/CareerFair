package kg.neobis.careerfair.ui.contest

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.FileUtils
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

    override fun onHintSelectedAt(position: Int) {
        showHint(position)
    }

    private fun initAdapter() {
        val namesOfContests = resources.getStringArray(R.array.name_contests)
        mAdapter = ContestAdapter(this, namesOfContests!!)
        rvContest.adapter = mAdapter
    }

    override fun onItemSelectedAt(position: Int) {
        val intent = Intent(this, ContestActivityGoogleForm::class.java)
        val checkRegistration: String? = FileUtils.readCacheData<String>(this, position.toString())
        val urlsOfForms = resources.getStringArray(R.array.urls)
        if (checkRegistration == null) {
            intent.putExtra(Constants.URL_KEY, urlsOfForms[position])
            startActivity(intent)
        } else {
            Toast.makeText(this, "Вы уже учавствуете в этом конкурсе", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showHint(position: Int) {
        val ft = supportFragmentManager.beginTransaction()
        val prev = supportFragmentManager.findFragmentByTag(Constants.TAG_FOR_SHOW_DIALOG_FRAGMENT)

        if (prev != null) {
            ft.remove(prev)
        }
        ft.addToBackStack(null)

        val newFragment = DialogFragmentHint.newInstance(position)
        newFragment.show(ft, Constants.TAG_FOR_SHOW_DIALOG_FRAGMENT)
    }
}
