package kg.neobis.careerfair.ui.organizers

import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.utils.custom_classes.IProgressBar

interface OrganizersContract {
    interface  View : IProgressBar{
        fun onError(message: String?)
        fun onSuccess(result: List<Organizers>)
    }
    interface Presenter {

        fun getOrganizers()
        fun getInfo(requestUrl: String)
    }
}