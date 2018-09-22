package kg.neobis.careerfair.ui.about_career_fair

import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.utils.IProgressBar

interface AboutCareerFairContract {

    interface  View : IProgressBar {
        fun  onSuccessAboutCarerrFair(result: List<AboutCareerFair>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getInfoAboutCareerFair(path : String)
    }
}