package kg.neobis.careerfair.ui.shedule


import kg.neobis.careerfair.model.Shedule
import kg.neobis.careerfair.utils.IProgressBar

interface ScheduleContract {
    interface  View : IProgressBar {
        fun  onSuccess(result: ArrayList<Shedule>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getSchedule()
    }
}