package kg.neobis.careerfair.ui.organizers

import kg.neobis.careerfair.utils.custom_classes.IProgressBar

interface OrganizersContract {
    interface  View : IProgressBar{
        fun  onSuccess(result: List<Any>)
        fun onError(message: String?)
    }
    interface Presenter {
        fun getOrganizers()
    }
}