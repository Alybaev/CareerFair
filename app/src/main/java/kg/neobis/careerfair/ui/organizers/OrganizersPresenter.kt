package kg.neobis.careerfair.ui.organizers

import android.text.TextUtils
import android.util.Log
import kg.neobis.careerfair.model.Organizers
import kg.neobis.careerfair.utils.custom_classes.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrganizersPresenter(val view: OrganizersContract.View?) : OrganizersContract.Presenter {
    override fun getOrganizers() {
        view?.showProgress()
        ApplicationClass.service.getOrganizers().enqueue(object : Callback<ArrayList<Organizers>> {
            override fun onResponse(call: Call<ArrayList<Organizers>>?, response: Response<ArrayList<Organizers>>?) {
                if (response!!.isSuccessful && response.body() != null) {
                    Log.d("______name", response.message())
                    view?.onSuccess(response.body()!!)
                } else {
                    view?.onError("Ошибка")
                }
                view?.hideProgress()
            }

            override fun onFailure(call: Call<ArrayList<Organizers>>?, t: Throwable?) {
                view?.onError("Не удалось получить данные")
                view?.hideProgress()
                t?.printStackTrace()
            }
        })
    }

    override fun getInfo(requestUrl: String?) {
        if (TextUtils.isEmpty(requestUrl))
            return
        view?.showProgress()
        ApplicationClass.service.getInfoAbout(requestUrl!!).enqueue(object : Callback<ArrayList<Organizers>> {
            override fun onResponse(call: Call<ArrayList<Organizers>>?, response: Response<ArrayList<Organizers>>?) {
                if (response!!.isSuccessful && response.body() != null) {
                    view?.onSuccess(response.body()!!)
                } else {
                    view?.onError("Ошибка")
                }
                view?.hideProgress()
            }

            override fun onFailure(call: Call<ArrayList<Organizers>>?, t: Throwable?) {
                view?.onError("Не удалось получить данные")
                view?.hideProgress()
                t?.printStackTrace()
            }
        })
    }
}