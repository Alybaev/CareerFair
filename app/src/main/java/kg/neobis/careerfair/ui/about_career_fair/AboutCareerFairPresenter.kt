package kg.neobis.careerfair.ui.about_career_fair

import kg.neobis.careerfair.model.AboutCareerFair
import kg.neobis.careerfair.utils.custom_classes.ApplicationClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutCareerFairPresenter(var view: AboutCareerFairContract.View?) : AboutCareerFairContract.Presenter {

    override fun getInfoAboutCareerFair() {
        view?.showProgress()
        ApplicationClass.service.getInfoAboutCareerFair().enqueue(object : Callback<ArrayList<AboutCareerFair>> {
            override fun onResponse(call: Call<ArrayList<AboutCareerFair>>?, response: Response<ArrayList<AboutCareerFair>>?) {
                if (response!!.isSuccessful && response.body() != null) {
                    view?.onSuccessAboutCarerrFair(response.body()!!)
                } else {
                    view?.onError("Ошибка")
                }
                view?.hideProgress()
            }

            override fun onFailure(call: Call<ArrayList<AboutCareerFair>>?, t: Throwable?) {
                view?.onError("Не удалось получить данные")
                view?.hideProgress()
                t?.printStackTrace()
            }
        })
    }
}