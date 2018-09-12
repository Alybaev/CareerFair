package kg.neobis.careerfair.ui.shedule

import kg.neobis.careerfair.utils.custom_classes.IProgressBar

interface SheduleContract {
    interface  View : IProgressBar {
        fun  onSuccess(result: List<Any>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getShedule()
    }
}