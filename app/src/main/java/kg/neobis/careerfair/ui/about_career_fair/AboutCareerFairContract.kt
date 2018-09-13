package kg.neobis.careerfair.ui.about_career_fair

import kg.neobis.careerfair.utils.custom_classes.IProgressBar

interface AboutCareerFairContract {

    interface  View : IProgressBar {
        fun  onSuccess(result: List<Any>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getInfoAboutCareerFair()
    }
}