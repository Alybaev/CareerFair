package kg.neobis.careerfair.ui.about_career_fair

import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.utils.custom_classes.IProgressBar

interface AboutCareerFairContract {

    interface  View : IProgressBar {
        fun  onSuccess(result: List<AboutCareerFair>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getInfoAboutCareerFair()
    }
}