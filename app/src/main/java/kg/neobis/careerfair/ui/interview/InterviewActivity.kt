package kg.neobis.careerfair.ui.interview

import android.os.Bundle
import kg.neobis.careerfair.R
import kg.neobis.careerfair.ui.BaseActivity
import kg.neobis.careerfair.utils.Constants
import kotlinx.android.synthetic.main.activity_interview.*

class InterviewActivity : BaseActivity(), InterviewAdapter.Listener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interview)
        val topicsOfInterview = resources.getStringArray(R.array.interview_topics)
        rvInterView.adapter = InterviewAdapter(topicsOfInterview, this)
    }

    override fun onItemSelectedAt(position: Int) {
        val url = when(position){
            0-> Constants.URL_OF_INTERVIEW_TENDENCY_OF_CAREER
            1-> Constants.URL_OF_INTERVIEW_QUESTIONS_OF_DIRECTORS
            else -> null
        }
    }
}