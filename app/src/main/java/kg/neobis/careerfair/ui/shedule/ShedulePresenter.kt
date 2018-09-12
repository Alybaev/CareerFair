package kg.neobis.careerfair.ui.shedule

import android.util.Log
import kg.neobis.careerfair.model.Shedule
import kg.neobis.careerfair.utils.custom_classes.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShedulePresenter(val view: SheduleContract.View) : SheduleContract.Presenter {
    override fun getShedule() {
        if (isViewAttached()) {
            view?.showProgress()
            ApplicationClass.service.getSheduleList().enqueue(object : Callback<List<Shedule>> {
                override fun onResponse(call: Call<List<Shedule>>?, response: Response<List<Shedule>>?) {
                    if (isViewAttached()) {
                        if (response!!.isSuccessful && response.body() != null) {

                            Log.d("______time", response.message())
                            view!!.onSuccess(response.body()!!)
                        } else {
                            view!!.onError("Не удалось получить данные")
                        }
                        view.hideProgress()
                    }
                }

                override fun onFailure(call: Call<List<Shedule>>?, t: Throwable?) {
                    if (isViewAttached()) {
                        view!!.onError("Не удалось получить данные")
                        view.hideProgress()
                    }
                    t?.printStackTrace()
                }
            })
        }

    }
    private fun isViewAttached(): Boolean = view != null
}