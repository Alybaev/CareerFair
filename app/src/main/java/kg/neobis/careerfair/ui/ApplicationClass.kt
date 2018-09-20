package kg.neobis.careerfair.ui

import android.app.Application
import kg.neobis.careerfair.utils.Constants.BASE_URL
import kg.neobis.careerfair.data.ForumService
import kg.neobis.careerfair.data.NetWork

class ApplicationClass : Application(){
    companion object {
        @Volatile
        lateinit var INSTANCE : ApplicationClass
        lateinit var service: ForumService
    }
    override fun onCreate(){
        super.onCreate()
        INSTANCE = this
        service = NetWork.initService(BASE_URL)

    }

}