package kg.neobis.careerfair.ui.organizers

import kg.neobis.careerfair.utils.CustomClasses.IProgressBar

interface OrganizersContract {
    interface  View : IProgressBar{
        fun  onSuccess(result: List<Any>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getOrganizers()
    }
}