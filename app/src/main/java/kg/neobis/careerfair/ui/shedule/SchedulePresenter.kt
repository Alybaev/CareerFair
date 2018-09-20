package kg.neobis.careerfair.ui.shedule

import kg.neobis.careerfair.model.Shedule
import kg.neobis.careerfair.ui.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchedulePresenter(val view: ScheduleContract.View?) : ScheduleContract.Presenter {
    override fun getSchedule() {
        view?.showProgress()
        ApplicationClass.service.getScheduleList().enqueue(object : Callback<ArrayList<Shedule>> {
            override fun onResponse(call: Call<ArrayList<Shedule>>?, response: Response<ArrayList<Shedule>>?) {
                if (response!!.isSuccessful && response.body() != null) {
                    view?.onSuccess(response.body()!!)
                } else {
                    view?.onError("Ошибка")
                }
                view?.hideProgress()
            }

            override fun onFailure(call: Call<ArrayList<Shedule>>?, t: Throwable?) {
                view?.onError("Не удалось получить данные")
                view?.hideProgress()
                t?.printStackTrace()
            }
        })
    }
}