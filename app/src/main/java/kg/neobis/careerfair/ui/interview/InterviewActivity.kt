package kg.neobis.careerfair.ui.interview

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.ui.contest.ContestActivityGoogleForm
import kg.neobis.careerfair.ui.custom.CustomTabForWebView
import kg.neobis.careerfair.utils.Constants
import kg.neobis.careerfair.utils.FileUtils
import kotlinx.android.synthetic.main.activity_interview.*

class InterviewActivity : BaseActivity(), InterviewAdapter.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)
        val topicsOfInterview = resources.getStringArray(R.array.interview_topics)
        rvInterView.adapter = InterviewAdapter(topicsOfInterview, this)
    }

    override fun onItemSelectedAt(position: Int) {
        var customTabWebView = CustomTabForWebView()
        var url : String? = null
        when (position) {
            0 -> url = Constants.URL_OF_INTERVIEW_TENDENCY_OF_CAREER
            1 -> url =  Constants.URL_OF_INTERVIEW_QUESTIONS_OF_DIRECTORS
            2 -> {
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
            else -> null
        }
        if(url != null) {
            customTabWebView.openUrlInChromeCustomTab(this, url!!)
        }
    }
}