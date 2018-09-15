package kg.neobis.careerfair.ui.shedule


import kg.neobis.careerfair.utils.custom_classes.IProgressBar

interface ScheduleContract {
    interface  View : IProgressBar {
        fun  onSuccess(result: List<Any>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getSchedule()
    }
}