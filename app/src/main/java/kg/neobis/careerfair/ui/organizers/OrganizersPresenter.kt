package kg.neobis.careerfair.ui.organizers
import android.util.Log
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.utils.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class OrganizersPresenter(val view: OrganizersContract.View) : OrganizersContract.Presenter {
    override fun getOrganizers() {
        if (isViewAttached()) {
            view?.showProgress()
            ApplicationClass.service.getOrganizersList().enqueue(object : Callback<List<Organizers>> {
                override fun onResponse(call: Call<List<Organizers>>?, response: Response<List<Organizers>>?) {
                    if (isViewAttached()) {
                        if (response!!.isSuccessful && response.body() != null) {

                            Log.d("______name", response.message())
                            view!!.onSuccess(response.body()!!)
                        } else {
                            view!!.onError("error")
                        }
                        view.hideProgress()
                    }
                }

                override fun onFailure(call: Call<List<Organizers>>?, t: Throwable?) {
                    if (isViewAttached()) {
                        view!!.onError("error")
                        view.hideProgress()
                    }
                    t?.printStackTrace()
                }
            })
        }

    }

    private fun isViewAttached(): Boolean = view != null
}

