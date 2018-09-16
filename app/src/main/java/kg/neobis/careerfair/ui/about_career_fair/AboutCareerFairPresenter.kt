package kg.neobis.careerfair.ui.about_career_fair

import android.util.Log
import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.model.Shedule
import kg.neobis.careerfair.utils.custom_classes.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutCareerFairPresenter(var view:AboutCareerFairContract.View) : AboutCareerFairContract.Presenter {

    override fun getInfoAboutCareerFair() {
        if (isViewAttached()) {
            view?.showProgress()
            ApplicationClass.service.getInfoAboutCareerFair().enqueue(object : Callback<List<AboutCareerFair>> {
                override fun onResponse(call: Call<List<AboutCareerFair>>?, response: Response<List<AboutCareerFair>>?) {
                    if (isViewAttached()) {
                        if (response!!.isSuccessful && response.body() != null) {

                            Log.d("______about", response.message())
                            view!!.onSuccessAboutCarerrFair(response.body()!!)
                        } else {

                            view!!.onError("Ошибка")
                        }
                        view.hideProgress()
                    }
                }

                override fun onFailure(call: Call<List<AboutCareerFair>>?, t: Throwable?) {
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